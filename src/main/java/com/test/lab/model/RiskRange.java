package com.test.lab.model;

import com.test.lab.constant.RiskType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@Document
public class RiskRange {
    @Id
    private String id;

    @NotNull()
    private String bloodTestTypeId;

    @Min(value = 0 , message = "El porcentaje no puede ser menor a 0")
    @Max(value = 100 , message = "El porcentaje no puede ser mayor a 100")
    @NotNull()
    private Double fromPercentage;

    @Min(value = 0 , message = "El porcentaje no puede ser menor a 0")
    @Max(value = 100 , message = "El porcentaje no puede ser mayor a 100")
    @NotNull()
    private Double toPercentage;

    @NotNull()
    private RiskType risk;
}
