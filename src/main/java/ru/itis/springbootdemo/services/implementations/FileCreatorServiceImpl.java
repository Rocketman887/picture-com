package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.services.interfacies.FileCreatorService;
import ru.itis.springbootdemo.services.interfacies.FilesPathService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileCreatorServiceImpl implements FileCreatorService {


    @Override
    public String createFile(String uploadPath, MultipartFile file) throws IOException {
        File uploadDirectory = new File(uploadPath);

        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdir();
        }
        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "." + file.getOriginalFilename();
        String resultFileNameForCreate =  uploadPath + "/" + resultFileName;

        file.transferTo(new File(resultFileNameForCreate));

        return resultFileName;
    }
}
