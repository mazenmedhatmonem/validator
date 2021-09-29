package com.jumia.validator.controller;

import com.jumia.validator.bo.CountryBo;
import com.jumia.validator.bo.CustomerBo;
import com.jumia.validator.service.countryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/countries")
public class countryController {

    @Autowired
    private countryService countryService;

    @GetMapping
    public List<String> getAllCustomers() {
        return countryService.getAllCountries();
    }

}
