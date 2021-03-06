package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.services.interfacies.FilesPathService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FilesPathServiceImpl implements FilesPathService {
    @Override
    public String createPath(String filename,String uploadPath) {
        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "." + filename;
        return uploadPath + "/" + resultFileName;
    }
}
