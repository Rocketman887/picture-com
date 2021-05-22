package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.dtos.dtos.ImagePostDTO;
import ru.itis.springbootdemo.models.ImagePost;

public interface ImagePostDTOService {
    ImagePostDTO imagePostDTOFrom(ImagePost imagePost);
}
