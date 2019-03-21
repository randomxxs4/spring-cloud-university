package ru.university.tableservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.university.tableservice.entity.Table;

public interface TableRepository extends MongoRepository<Table, Long> {
}
