package com.jumia.validator.service;

import com.jumia.validator.repository.CustomerRepository;
import com.jumia.validator.util.regexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class countryService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private regexUtil regexUtil;

    public List<String> getAllCountries() {
        return com.jumia.validator.util.regexUtil.regexCountryCodeMap.entrySet()
                .stream()
                .map(entry -> entry.getValue().getName())
                .collect(Collectors.toList());
    }
}
