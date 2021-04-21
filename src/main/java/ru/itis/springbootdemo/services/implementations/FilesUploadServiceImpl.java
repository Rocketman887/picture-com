package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.services.interfacies.FileCreatorService;
import ru.itis.springbootdemo.services.interfacies.FilesUploadService;
import ru.itis.springbootdemo.services.interfacies.UsersService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FilesUploadServiceImpl implements FilesUploadService {


    private final FileCreatorService fileCreatorService;

    private final UsersService usersService;

    @Value("${default.uploads}")
    private String uploadPath;

    @Override
    public void addImage(UserDTO userDTO, MultipartFile file) throws IOException {
        if (file != null) {
            String resultFileName = fileCreatorService.createFile(uploadPath,file);
            User user = usersService.getUserById(userDTO.getId());
            user.setProfileImagePath(resultFileName);
            usersService.saveUser(user);
        }
    }

}
