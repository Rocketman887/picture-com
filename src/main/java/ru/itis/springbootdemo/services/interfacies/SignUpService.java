package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.dtos.forms.UserForm;

public interface SignUpService {
    boolean signUp(UserForm userForm);
}
