package com.jumia.validator.service;


import com.jumia.validator.bo.CountryBo;
import com.jumia.validator.bo.CustomerBo;
import com.jumia.validator.entity.Customer;
import com.jumia.validator.repository.CustomerRepository;
import com.jumia.validator.util.regexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import org.assertj.core.util.Lists;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private regexUtil regexUtil;

    public List<CustomerBo> getAllCustomers() {
        List<CustomerBo> allCustomers = Lists.newArrayList();
        for(Customer customer : customerRepository.findAll()) {
            CustomerBo customerBo = new CustomerBo();
            customerBo.setName(customer.getName());
            customerBo.setPhoneNumber(customer.getPhone());
            String countryCode = StringUtils.substring(customer.getPhone(), customer.getPhone().indexOf("(") + 1, customer.getPhone().indexOf(")"));
            if(regexUtil.regexCountryCodeMap.containsKey(countryCode)) {
                CountryBo countryBo = regexUtil.regexCountryCodeMap.get(countryCode);
                customerBo.setCountryName(countryBo.getName());
                customerBo.setValid(customer.getPhone().matches(countryBo.getValidRegexPattern()));
            }
            allCustomers.add(customerBo);
        }
        return allCustomers;
    }
}
