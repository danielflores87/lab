package com.test.lab.controller;


import com.test.lab.LabApplication;
import com.test.lab.model.RiskRange;
import com.test.lab.repository.RiskRangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/risk-range")
public class RiskRangeController {

    @Autowired
    private RiskRangeRepository riskRangeRepository;

    @GetMapping("/get-all")
    List<RiskRange> index() {
        return riskRangeRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    RiskRange create(@RequestBody @Valid RiskRange riskRange) {
        return riskRangeRepository.save(riskRange);
    }
}
