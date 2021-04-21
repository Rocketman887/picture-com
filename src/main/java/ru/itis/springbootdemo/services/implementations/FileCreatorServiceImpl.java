package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.services.interfacies.FileCreatorService;
import ru.itis.springbootdemo.services.interfacies.FilesPathService;
import ru.itis.springbootdemo.services.interfacies.FilesUploadService;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileCreatorServiceImpl implements FileCreatorService {

    private final FilesPathService filesPathService;

    @Override
    public String createFile(String uploadPath, MultipartFile file) throws IOException {
        File uploadDirectory = new File(uploadPath);

        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdir();
        }
        String resultFileName = filesPathService.createPath(file.getOriginalFilename(),uploadPath);
        file.transferTo(new File(resultFileName));
        return resultFileName;
    }
}
