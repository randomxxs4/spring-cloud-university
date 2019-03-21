package ru.university.authservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.university.authservice.repository.UserRepository;
import ru.university.authservice.entity.User;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(User user) {
        Optional<User> existing = repository.findById(user.getUsername());
        existing.ifPresent(item -> {
            throw new IllegalArgumentException(String.format("User %s already exists", user.getUsername()));
        });
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        repository.save(user);
        if (log.isDebugEnabled()) {
            log.debug("New user has been created: {}", user.getUsername());
        }
    }
}
