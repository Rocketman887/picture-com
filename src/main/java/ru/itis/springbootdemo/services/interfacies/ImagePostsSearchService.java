package ru.itis.springbootdemo.services.interfacies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.dtos.forms.ImagePostSearchForm;
import ru.itis.springbootdemo.models.ImagePost;

public interface ImagePostsSearchService {
     Page<ImagePost> findAllBySearchForm(ImagePostSearchForm searchForm);

}
