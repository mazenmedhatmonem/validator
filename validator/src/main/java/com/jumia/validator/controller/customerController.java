package com.jumia.validator.controller;

import com.jumia.validator.bo.CustomerBo;
import com.jumia.validator.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/customers")
public class customerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerBo> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
