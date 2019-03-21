package ru.university.tableservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.university.tableservice.entity.Table;
import ru.university.tableservice.service.TableService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tables")
public class TableController {

    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping
    public void createTable(@RequestBody Table table) {
        tableService.save(table);
    }

    @GetMapping(value = "/all")
    public List<Table> getAll() {
        return new ArrayList<>(tableService.getAll());
    }
}
