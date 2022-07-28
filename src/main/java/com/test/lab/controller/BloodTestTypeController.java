package com.test.lab.controller;

import com.test.lab.model.BloodTest;
import com.test.lab.model.BloodTestType;
import com.test.lab.repository.BloodTestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/blood-test-type")
public class BloodTestTypeController {

    @Autowired
    private BloodTestTypeRepository bloodTestTypeRepository;

    @GetMapping("/get-all")
    List<BloodTestType> index() {
        return bloodTestTypeRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    BloodTestType create(@RequestBody @Valid BloodTestType bloodTestType) {
        return bloodTestTypeRepository.save(bloodTestType);
    }

}
