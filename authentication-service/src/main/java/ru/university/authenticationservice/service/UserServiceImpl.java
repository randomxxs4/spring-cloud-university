package ru.university.authenticationservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.university.authenticationservice.entity.User;
import ru.university.authenticationservice.repository.UserRepository;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User \'%s\' not found", username)));
    }

    @Override
    public void createUser(User user) {
        userRepository.findById(user.getUsername()).ifPresent((u) -> {
            throw new IllegalArgumentException(String.format("User \'%s\' already exists", u.getUsername()));
        });
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        userRepository.save(user);

        if (log.isDebugEnabled()) {
            log.debug("New user created successfully {}", user.getUsername());
        }
    }
}
