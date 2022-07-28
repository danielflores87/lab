package com.test.lab.controller;

import com.test.lab.dto.CreatePatientTestsDTO;
import com.test.lab.model.BloodTest;
import com.test.lab.model.BloodTestType;
import com.test.lab.model.Patient;
import com.test.lab.repository.BloodTestRepository;
import com.test.lab.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/blood-test")
public class BloodTestController {

    @Autowired
    private BloodTestRepository bloodTestRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/get-all")
    List<BloodTest> getAll() {
        return bloodTestRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    BloodTest create(@RequestBody @Valid BloodTest bloodTest) {
        return bloodTestRepository.save(bloodTest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable String id) {
        BloodTest bloodTest = bloodTestRepository.findById(id).orElseThrow(RuntimeException::new);

        bloodTestRepository.delete(bloodTest);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-many")
    String createMany(@RequestBody @Valid List<CreatePatientTestsDTO> createPatientTestsDTOList) {

        createPatientTestsDTOList.forEach(data -> {
            String document = data.getPatientDocument();
            Patient patient = patientRepository.findById(document).orElse(null);

            if(patient == null) {
                Patient newPatient = new Patient();
                newPatient.setName(data.getPatientName());
                newPatient.setDocumentNumber(document);
                newPatient.setContactNumber("");

                patientRepository.save(newPatient);
            }

            List<BloodTest> patientTests = bloodTestRepository.findByPatientDocument(document);

            data.getTests().forEach(test -> {
              BloodTest bl = patientTests.stream()
                                    .filter(i -> i.getBloodTestTypeId().equals(test.getBloodTest()) )
                                    .findFirst()
                                    .orElse(null);

              if(test.getPercentageResult() > 100 || test.getPercentageResult() < 0){
                  throw new RuntimeException("El porcentaje debe ser entre 0 y 100");
              }


              if(bl != null) {
                  bloodTestRepository.deleteById(bl.getId());
              }
                  BloodTest bloodTest = new BloodTest();
                  bloodTest.setBloodTestTypeId(test.getBloodTest());
                  bloodTest.setPatientDocument(document);
                  bloodTest.setPercentageResult(test.getPercentageResult());
                  bloodTestRepository.save(bloodTest);

            });
        });

        return "Se agregaron los resultados de las pruebas, correctamente!.";
    }


}
