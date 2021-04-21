
package ru.itis.springbootdemo.dtos.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.dtos.mappers.UserDTOMapper;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {


    private Long id;
    @NotNull
    private String name;

    private String email;

    private String role;

    private String state;

    private String code;

    private String imagePath;
}
