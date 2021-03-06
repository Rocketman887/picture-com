package ru.itis.springbootdemo.services.interfacies;

public interface EmailConfirmationService {
    boolean confirmByCode(String code);
}
