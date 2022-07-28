package com.test.lab.repository;

import com.test.lab.model.BloodTest;
import com.test.lab.model.RiskRange;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RiskRangeRepository extends MongoRepository<RiskRange, String> {
}
