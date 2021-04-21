package ru.itis.springbootdemo.services.interfacies;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;

import java.io.IOException;

public interface FilesUploadService {
    void addImage(UserDTO userDTO, MultipartFile file) throws IOException;
}
