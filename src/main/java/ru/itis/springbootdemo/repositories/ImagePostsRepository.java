package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.ImagePost;

public interface ImagePostsRepository extends JpaRepository<ImagePost,Long> {
}
