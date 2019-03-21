package ru.university.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {

    ADMIN,
    STUDENT,
    TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
