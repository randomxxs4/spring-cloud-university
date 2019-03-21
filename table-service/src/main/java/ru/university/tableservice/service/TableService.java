package ru.university.tableservice.service;

import ru.university.tableservice.entity.Table;

import java.util.Collection;

public interface TableService {

    Table getOne(Long id);

    Collection<Table> getAll();

    void save(Table table);

    void delete(Long id);
}
