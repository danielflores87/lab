package com.test.lab.dto;

import com.test.lab.constant.RiskType;

import java.util.List;

public class TestResultDTO {

    String patientDocument;
    String patientName;
    RiskType risk;
    List<TestDTO> tests;

    public RiskType getRisk() {
        return risk;
    }

    public void setRisk( RiskType tests) {
        this.risk = risk;
    }

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

    public TestResultDTO(String patientDocument, String patientName, List<TestDTO> tests , RiskType risk) {
        super();
        this.patientDocument = patientDocument;
        this.patientName = patientName;
        this.tests = tests;
        this.risk = risk;
    }


}
