package ru.itis.springbootdemo.services.interfacies;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileCreatorService {
    String createFile(String uploadPath,MultipartFile file) throws IOException;
}
