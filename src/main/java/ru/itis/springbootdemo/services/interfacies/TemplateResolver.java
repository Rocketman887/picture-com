package ru.itis.springbootdemo.services.interfacies;

import java.util.Map;

public interface TemplateResolver {
    String process(String name, Map<String, String> root);
}