package ru.itis.springbootdemo.services.implementations;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.security.enterprise.SecurityContext;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        SecurityContext securityContext = (SecurityContext) SecurityContextHolder.getContext();
        if(((org.springframework.security.core.context.SecurityContext) securityContext).getAuthentication() != null){
            return Optional.of(((org.springframework.security.core.context.SecurityContext) securityContext).getAuthentication().getDetails().toString());
        }
        return Optional.empty();
    }

}
