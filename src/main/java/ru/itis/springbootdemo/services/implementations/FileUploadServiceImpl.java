package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.dtos.ProfileDTO;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.interfacies.FileCreatorService;
import ru.itis.springbootdemo.services.interfacies.FilesPathService;
import ru.itis.springbootdemo.services.interfacies.FilesUploadService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FilesUploadService {

    @Value("${uploads.posts}")
    private final String postUploadPath;

    @Value("${uploads.profiles}")
    private final String profileUploadPath;

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final FileCreatorService fileCreatorService;

    @Override
    public void addImageToProfile(ProfileDTO profile, MultipartFile file) throws IOException {
        if (file != null) {
            String resultFileName = fileCreatorService.createFile(profileUploadPath,file);
            usersRepository.addImageNameByUserId(profile.getUserID(), resultFileName);

        }
    }

    @Override
    public void addImageToPost(ProfileDTO profile, MultipartFile file) throws IOException {
        if (file != null) {
            String resultFileName = fileCreatorService.createFile(postUploadPath,file);
            usersRepository.addImageNameByUserId(profile.getUserID(), resultFileName);

        }
    }


}
