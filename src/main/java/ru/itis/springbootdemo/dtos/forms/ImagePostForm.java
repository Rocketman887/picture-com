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
public class ImagePostForm {

    @NotNull
    private String owner;

    @NotNull
    private String imagePath;

    @NotBlank(message = "{error.null_email}")
    private String title;

    @NotBlank(message = "{error.null_email}")
    private String tag;

    private String description;

}