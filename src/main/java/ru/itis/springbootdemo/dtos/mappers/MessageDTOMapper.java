package ru.itis.springbootdemo.dtos.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.itis.springbootdemo.dtos.dtos.MessageDTO;
import ru.itis.springbootdemo.models.Message;

@Mapper(componentModel="spring")
public interface MessageDTOMapper {
    MessageDTOMapper MAPPER = Mappers.getMapper(MessageDTOMapper.class);

    @Mappings({
            @Mapping(target = "text", source = "dto.text"),
    })
    Message dtoToMessage(MessageDTO dto);

    @InheritInverseConfiguration
    MessageDTO messageToDTO(Message message);
}
