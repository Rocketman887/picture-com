package ru.itis.springbootdemo.dtos.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.models.User;

@Mapper(componentModel = "spring")
public interface ImagePostFormMapper {
    ImagePostFormMapper MAPPER = Mappers.getMapper(ImagePostFormMapper.class);

    @Mappings({
            @Mapping(target = "title", source = "form.title"),
            @Mapping(target = "type", source = "form.type"),
            @Mapping(target = "description",source = "form.description"),
            @Mapping(target = "imagePath",source = "form.imagePath")
    })
    ImagePost formToImagePost(ImagePostForm form);

    @InheritInverseConfiguration
    ImagePostForm imagePostToForm(ImagePost imagePost);
}
