package ru.university.tableservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.university.tableservice.entity.Table;
import ru.university.tableservice.repository.TableRepository;
import ru.university.tableservice.service.TableService;

import java.util.Collection;

@Service
public class TableServiceImpl implements TableService {

    private final TableRepository tableRepository;

    @Autowired
    public TableServiceImpl(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public Table getOne(Long id) {
        return tableRepository.findById(id).orElse(new Table());
    }

    @Override
    public Collection<Table> getAll() {
        return tableRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Table table) {
        tableRepository.save(table);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tableRepository.deleteById(id);
    }
}
