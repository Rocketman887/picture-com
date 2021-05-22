package ru.itis.springbootdemo.dtos.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.itis.springbootdemo.dtos.dtos.ImagePostDTO;
import ru.itis.springbootdemo.models.ImagePost;

@Mapper(componentModel = "spring")
public interface ImagePostDTOMapper {
    ImagePostDTOMapper MAPPER = Mappers.getMapper(ImagePostDTOMapper.class);

    @Mappings({
            @Mapping(target = "id",source = "dto.id"),
            @Mapping(target = "title", source = "dto.title"),
            @Mapping(target = "type", source = "dto.type"),
            @Mapping(target = "tag", source = "dto.tag"),
            @Mapping(target = "description", source = "dto.description"),
            @Mapping(target = "imagePath", source = "dto.imagePath")
    })
    ImagePost DTOToImagePost(ImagePostDTO dto);

    @InheritInverseConfiguration
    ImagePostDTO imagePostToDTO(ImagePost imagePost);
}
