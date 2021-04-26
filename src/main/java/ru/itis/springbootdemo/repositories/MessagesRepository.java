package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Message;

public interface MessagesRepository extends JpaRepository<Message,Long> {
}
