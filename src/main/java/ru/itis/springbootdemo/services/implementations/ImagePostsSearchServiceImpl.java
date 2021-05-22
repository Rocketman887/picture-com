package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.dtos.forms.ImagePostSearchForm;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.repositories.ImagePostsRepository;
import ru.itis.springbootdemo.services.interfacies.ImagePostsSearchService;

@Service
@RequiredArgsConstructor
public class ImagePostsSearchServiceImpl implements ImagePostsSearchService {

    private final ImagePostsRepository imagePostsRepository;
    @Override
    public Page<ImagePost> findByTitle(String title,Pageable pageable) {
        return imagePostsRepository.findByTitle(title,pageable);
    }

    @Override
    public Page<ImagePost> findByTag(String tag, Pageable pageable) {
        return imagePostsRepository.findByTag(tag,pageable);
    }

    @Override
    public Page<ImagePost> findByType(String type, Pageable pageable) {
        return imagePostsRepository.findByType(type,pageable);
    }
}

