package ru.itis.springbootdemo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.models.User;

public interface ImagePostsRepository extends JpaRepository<ImagePost,Long> {
    Page<ImagePost> findAll(Pageable pageable);

    @Query("select i from ImagePost i where lower(i.title) like lower(concat('%', :title,'%')) ")
    Page<ImagePost> findByTitle(@Param("title") String title, Pageable pageable);

    @Query("select i from ImagePost i where lower(i.tag) like lower(concat('%', :tag,'%')) ")
    Page<ImagePost> findByTag(@Param("tag") String tag, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM image_post WHERE type = :type")
    Page<ImagePost> findByType(@Param("type") String type,Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM image_post WHERE user_id = :id")
    Page<ImagePost> findAllByOwner(Long id, Pageable pageable);
}