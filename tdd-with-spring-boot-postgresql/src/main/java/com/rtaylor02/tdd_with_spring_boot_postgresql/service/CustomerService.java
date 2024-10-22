package com.rtaylor02.tdd_with_spring_boot_postgresql.service;

import com.rtaylor02.tdd_with_spring_boot_postgresql.dao.CustomerDao;
import com.rtaylor02.tdd_with_spring_boot_postgresql.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getAllCustomers() {
        Iterable<CustomerEntity> customerEntityList = customerDao.findAll();
        List<Customer> customers = new ArrayList<>();
        customerEntityList.forEach(entity -> customers.add(new Customer(
                entity.getCustomerId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmailAddress(),
                entity.getPhoneNumber(),
                entity.getAddress())));

        return customers;
    }
}
