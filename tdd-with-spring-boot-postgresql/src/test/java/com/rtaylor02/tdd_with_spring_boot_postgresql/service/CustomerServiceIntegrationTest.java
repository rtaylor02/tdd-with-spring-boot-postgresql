package com.rtaylor02.tdd_with_spring_boot_postgresql.service;

import com.rtaylor02.tdd_with_spring_boot_postgresql.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CustomerServiceIntegrationTest {
    @Autowired
    private CustomerService customerService;

    @Test
    void shouldReturnFullList() {
        // ACT
        List<Customer> customers = customerService.getAllCustomers();

        // ASSERT
        assertEquals(5, customers.size());
    }
}
