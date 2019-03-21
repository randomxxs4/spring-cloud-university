package ru.university.authenticationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
    STUDENT,
    TEACHER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
