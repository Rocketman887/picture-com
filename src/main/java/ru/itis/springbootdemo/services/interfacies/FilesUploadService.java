package ru.itis.springbootdemo.services.interfacies;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.dtos.ImagePostDTO;
import ru.itis.springbootdemo.dtos.dtos.ProfileDTO;

import java.io.IOException;

public interface FilesUploadService {
    void addImageToProfile(ProfileDTO profile, MultipartFile file) throws IOException;
    void addImageToPost(ProfileDTO profile, MultipartFile file) throws IOException;
}
