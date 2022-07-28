package com.test.lab.repository;


import com.test.lab.model.BloodTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BloodTestRepository extends MongoRepository<BloodTest, String> {

    @Query("{patientDocument :?0}")
    List<BloodTest> findByPatientDocument(String patientDocument);


}
