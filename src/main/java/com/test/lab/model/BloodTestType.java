package com.test.lab.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Document
public class BloodTestType {

    @NotNull()
    @Id
    private String id;

    @Size(min = 1, max = 50)
    @NotNull()
    private String name;

    @NotNull()
    private Boolean isActive;

}
