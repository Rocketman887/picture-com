package ru.itis.springbootdemo.dtos.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImagePostSearchForm {
    private String title;
    private String tag;
    private String type;
    private int page;
    private int size;
}
