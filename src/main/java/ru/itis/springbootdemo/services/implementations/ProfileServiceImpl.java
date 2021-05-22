package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.ProfileNameEditForm;
import ru.itis.springbootdemo.dtos.forms.ProfilePasswordEditForm;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.interfacies.FilesUploadService;
import ru.itis.springbootdemo.services.interfacies.ProfileService;
import ru.itis.springbootdemo.services.interfacies.UsersService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final PasswordEncoder passwordEncoder;
    private final UsersService usersService;
    private final FilesUploadService filesUploadService;

    @Value("${default.image.path}")
    private String defaultImage;
    @Override
    public boolean editName(ProfileNameEditForm form, UserDTO userDTO) {

        if(passwordEncoder.matches(form.getPassword(),usersService.getUserByEmail(userDTO.getEmail()).getHashPassword())) {
            userDTO.setName(form.getName());
            User user = usersService.getUserByEmail(userDTO.getEmail());
            user.setName(form.getName());
            usersService.saveUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean editPassword(ProfilePasswordEditForm form, UserDTO userDTO) {
        String newPassword = passwordEncoder.encode(form.getNewPassword());
        String repeatNewPassword = form.getRepeatNewPassword();
        if(passwordEncoder.matches((form.getOldPassword()),usersService.getUserByEmail(userDTO.getEmail()).getHashPassword())&&
        passwordEncoder.matches(repeatNewPassword,
                newPassword)){
            User user = usersService.getUserByEmail(userDTO.getEmail());
            user.setHashPassword(newPassword);
            usersService.saveUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void editImage(UserDTO userDTO, MultipartFile file) throws IOException {
        filesUploadService.addImageToUser(userDTO,file);
    }
    @Override
    public void deleteImage(UserDTO userDTO){
        User user = usersService.getUserById(userDTO.getId());
        user.setProfileImagePath(defaultImage);
        usersService.saveUser(user);
    }
}
