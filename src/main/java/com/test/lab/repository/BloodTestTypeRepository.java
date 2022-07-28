package com.test.lab.repository;

import com.test.lab.model.BloodTestType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BloodTestTypeRepository extends MongoRepository<BloodTestType, String> {
}
