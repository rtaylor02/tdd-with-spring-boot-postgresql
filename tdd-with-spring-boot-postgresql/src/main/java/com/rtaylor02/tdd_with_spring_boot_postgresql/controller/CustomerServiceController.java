package com.rtaylor02.tdd_with_spring_boot_postgresql.controller;

import com.rtaylor02.tdd_with_spring_boot_postgresql.model.Customer;
import com.rtaylor02.tdd_with_spring_boot_postgresql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerServiceController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> result = customerService.getAllCustomers();
        if (result != null) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
