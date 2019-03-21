package ru.university.authenticationservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.university.authenticationservice.entity.User;

public interface UserService extends UserDetailsService {

    void createUser(User user);

}
