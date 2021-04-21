package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.dtos.dtos.UserDTO;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface CookieService {
    void createCookie(ServletResponse servletResponse, UserDTO dto);
    Boolean checkCookie(ServletRequest servletRequest, String cookieName);
}
