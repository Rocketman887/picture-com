package ru.itis.springbootdemo.services.interfacies;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.ProfileNameEditForm;
import ru.itis.springbootdemo.dtos.forms.ProfilePasswordEditForm;

import java.io.IOException;

public interface ProfileService {
    boolean editName(ProfileNameEditForm form, UserDTO userDTO);
    boolean editPassword(ProfilePasswordEditForm form, UserDTO userDTO);
    void editImage(UserDTO userDTO, MultipartFile file) throws IOException;
}
