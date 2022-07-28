package com.test.lab.controller;

import com.test.lab.constant.RiskType;
import com.test.lab.dto.TestDTO;
import com.test.lab.dto.TestResultDTO;
import com.test.lab.model.BloodTest;
import com.test.lab.model.BloodTestType;
import com.test.lab.model.Patient;
import com.test.lab.model.RiskRange;
import com.test.lab.repository.BloodTestRepository;
import com.test.lab.repository.BloodTestTypeRepository;
import com.test.lab.repository.PatientRepository;
import com.test.lab.repository.RiskRangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private BloodTestRepository bloodTestRepository;
    @Autowired
    private RiskRangeRepository riskRangeRepository;
    @Autowired
    private BloodTestTypeRepository bloodTestTypeRepository;


    @GetMapping("/get-all")
    List<Patient> index() {
        return patientRepository.findAll();
    }


    @GetMapping("/get-test-result-by-document/{id}")
    TestResultDTO getTestResultByDocument(@PathVariable String id) {

        List<TestDTO> tests = new ArrayList<>();
        List<RiskType> results = new ArrayList<>();
        Patient patient = patientRepository.findById(id).orElseThrow(RuntimeException::new);
        List<BloodTest> bloodTests = bloodTestRepository.findByPatientDocument(id);
        List<RiskRange> riskRanges = riskRangeRepository.findAll();
        List<BloodTestType> bloodTypes = bloodTestTypeRepository.findAll();


        bloodTests.forEach(bloodTest -> {
            String type = bloodTest.getBloodTestTypeId();
            Double result = bloodTest.getPercentageResult();
            tests.add(new TestDTO(bloodTypes.stream()
                                            .filter(i-> i.getId().equals(type))
                                            .findFirst().get()
                                            .getName(), result));


            RiskType risk = riskRanges.stream()
                    .filter(range -> range.getBloodTestTypeId().equals(type)
                            && result >= range.getFromPercentage()
                            && result < range.getToPercentage()
                    )
                    .findFirst()
                    .get().getRisk();

            results.add(risk);

        });

        long high = results.stream().filter(i -> i.equals(RiskType.Alto)).count();
        long medium = results.stream().filter(i -> i.equals(RiskType.Medio)).count();
        long low = results.stream().filter(i -> i.equals(RiskType.Bajo)).count();

        RiskType globalRisk = high >= medium + low  ? RiskType.Alto :
                low >= high + medium ?  RiskType.Bajo :  RiskType.Medio;

        TestResultDTO toReturn = new TestResultDTO(
                patient.getDocumentNumber(),
                patient.getName(),
                tests,
                globalRisk);

        return toReturn;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    Patient create(@RequestBody @Valid Patient patient) {
        return patientRepository.save(patient);
    }

}
