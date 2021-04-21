package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.springbootdemo.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    boolean existsByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    @Query(nativeQuery = true,value = "UPDATE account SET image = :imageName where id = :id returning 1")
    void addImageNameByUserId(Long id,String imageName);
    Optional<User> findByCurrentConfirmationCode(String code);
}
