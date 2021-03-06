package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@PreAuthorize("isAuthenticated()")
@RestController
@RequiredArgsConstructor
public class ProfileController {

}
