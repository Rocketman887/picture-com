package ru.itis.springbootdemo.dtos.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImagePostDTO {

    @NotNull
    private String owner;

    @NotNull
    private String imagePath;

    @NotNull
    private String title;

    @NotNull
    private String tag;

    private String description;
}
