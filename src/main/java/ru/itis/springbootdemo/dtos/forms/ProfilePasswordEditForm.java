package ru.itis.springbootdemo.dtos.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfilePasswordEditForm {
    @Size(min = 10, message = "errors.short_password")
    private String oldPassword;

    @Size(min = 10, message = "errors.short_password")
    private String newPassword;

    @Size(min = 10, message = "errors.short_password")
    private String repeatNewPassword;
}
