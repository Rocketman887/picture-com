package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dtos.dtos.ImagePostDTO;
import ru.itis.springbootdemo.dtos.mappers.ImagePostDTOMapper;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.services.interfacies.ImagePostDTOService;

@Service
@RequiredArgsConstructor
public class ImagePostDTOServiceImpl implements ImagePostDTOService {

    @Override
    public ImagePostDTO imagePostDTOFrom(ImagePost imagePost) {
        ImagePostDTO imagePostDTO = ImagePostDTOMapper.MAPPER.imagePostToDTO(imagePost);
        imagePostDTO.setOwnerId(imagePost.getUser().getId());
        return imagePostDTO;
    }
}
