package ru.university.tableservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.university.tableservice.enums.Days;

import java.time.LocalTime;

@Document(collection = "tables")
@Data
@NoArgsConstructor
public class Table {

    @Id
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime time;

    private Days day;

    private Long groupId;
}
