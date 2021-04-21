package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dtos.forms.ImagePostSearchForm;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.repositories.ImagePostsRepository;
import ru.itis.springbootdemo.services.interfacies.ImagePostsSearchService;

@Service
@RequiredArgsConstructor
public class ImagePostsSearchServiceImpl implements ImagePostsSearchService {

    private final ImagePostsRepository imagePostsRepository;
    @Override
    public Page<ImagePost> findAllBySearchForm(ImagePostSearchForm searchForm) {
        PageRequest pageRequest = PageRequest.of(searchForm.getPage() - 1, 20 , Sort.unsorted());
        Page<ImagePost> imagePosts = imagePostsRepository.findAll(searchForm.getText(), pageRequest);
        return imagePosts.map(ImagePost::from);
    }

}

