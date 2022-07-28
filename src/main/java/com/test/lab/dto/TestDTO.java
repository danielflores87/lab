package com.test.lab.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@Document
public class TestDTO {
    @NotNull()
    String bloodTest;
    @Min(value = 0 , message = "El porcentaje no puede ser menor a 0")
    @Max(value = 100 , message = "El porcentaje no puede ser mayor a 100")
    @NotNull()
    Double percentageResult;

    public String getBloodTest() {
        return bloodTest;
    }

    public void setBloodTest(String bloodTest) {
        this.bloodTest = bloodTest;
    }

    public Double getPercentageResult() {
        return percentageResult;
    }

    public void setPercentageResult(Double percentageResult) {
        this.percentageResult = percentageResult;
    }

    public TestDTO(String bloodTest, Double percentageResult) {
        super();
        this.bloodTest = bloodTest;
        this.percentageResult = percentageResult;
    }

}
