package ru.university.authservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.university.authservice.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
