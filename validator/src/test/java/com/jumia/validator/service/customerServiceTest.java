package com.jumia.validator.service;

import com.jumia.validator.bo.CustomerBo;
import com.jumia.validator.entity.Customer;
import com.jumia.validator.repository.CustomerRepository;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class customerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllCustomersTest() {
        List<Customer> customers = Lists.newArrayList();
        Customer customerWithValidCode = new Customer();
        customerWithValidCode.setPhone("(237) 699209115");

        Customer customerWithInvalidCode = new Customer();
        customerWithInvalidCode.setPhone("(219834894797432) 43346980543197");
        customers.addAll(Lists.newArrayList(customerWithValidCode,customerWithInvalidCode));

        Mockito.when(customerRepository.findAll())
                .thenReturn(customers);

        List<CustomerBo> customersReturned = customerService.getAllCustomers();
        Assert.assertNotNull(customersReturned);
        Assert.assertEquals(2, customersReturned.size());
        Assert.assertEquals(customersReturned.get(0).isValid(),true);
        Assert.assertEquals(customersReturned.get(1).isValid(),false);

    }

}
