package ru.university.tableservice.service;

import ru.university.tableservice.entity.Table;

public interface TableService {
    Table getOne(Long id);
    Iterable<Table> findAll();
    void save(Table table);
    void delete(Long id);
}
