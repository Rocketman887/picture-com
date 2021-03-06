package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;


@PreAuthorize("isAuthenticated()")
@Controller
@RequiredArgsConstructor
public class ImagePostController {
}
