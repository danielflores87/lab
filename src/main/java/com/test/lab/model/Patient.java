package com.test.lab.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Document
public class Patient {
    @Id
    @Size(min = 1, max = 15)
    @NotNull()
    private String documentNumber;

    @Size(max = 100)
    private String name;

    @Size(min = 10, max = 10)
    private String contactNumber;

}
