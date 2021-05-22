package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.models.User;

import java.util.List;

public interface AdminService {
    void banUserById(Long id);
    void banAllUsers();
    void unBanUserById(Long id);
    void unBanAllUsers();
}
