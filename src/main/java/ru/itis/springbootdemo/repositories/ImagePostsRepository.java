package ru.itis.springbootdemo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springbootdemo.models.ImagePost;

public interface ImagePostsRepository extends JpaRepository<ImagePost,Long> {
    @Query("select i from ImagePost i where lower(i.title) like lower(concat('%', :titleToFind,'%')) ")
    Page<ImagePost> findAll(@Param("titleToFind") String title,
                            Pageable pageable);
}
