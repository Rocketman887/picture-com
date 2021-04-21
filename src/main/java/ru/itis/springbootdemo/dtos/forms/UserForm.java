package ru.itis.springbootdemo.dtos.forms;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {

    @Email(message = "${errors.wrong_email}")
    private String email;

    @Size(min = 2, message = "${errors.short_name}")
    private String name;

    @NotBlank(message = "${error.null_email}")
    @Size(min = 10, message = "${errors.short_password}")
    private String password;


}
