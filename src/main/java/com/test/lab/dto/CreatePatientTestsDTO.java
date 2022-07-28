package com.test.lab.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@Document
public class CreatePatientTestsDTO {
    @NotNull()
    String patientDocument;
    @NotNull()
    String patientName;
    @NotNull()
    List<TestDTO> tests;

    public List<TestDTO> getTests() {
        return tests;
    }

    public void setTests( List<TestDTO> tests) {
        this.tests = tests;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }

    public CreatePatientTestsDTO(String patientDocument, String patientName, List<TestDTO> tests ) {
        super();
        this.patientDocument = patientDocument;
        this.patientName = patientName;
        this.tests = tests;
    }

}
