package com.rtaylor02.tdd_with_spring_boot_postgresql.service;

import com.rtaylor02.tdd_with_spring_boot_postgresql.dao.CustomerDao;
import com.rtaylor02.tdd_with_spring_boot_postgresql.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    public static final int SIZE = 2;

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerDao customerDao;

    @Test
    void shouldReturnListOfCustomers() {
        // ARRANGE
        List<CustomerEntity> expectedList = getMockCustomers(SIZE);
        when(customerDao.findAll()).thenReturn(expectedList);

        // ACT
        List<Customer> actualList = customerService.getAllCustomers();

        // ASSERT
        assertEquals(SIZE, actualList.size());
    }

    private List<CustomerEntity> getMockCustomers(int size) {
        List<CustomerEntity> customerList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            customerList.add(new CustomerEntity(
                    UUID.randomUUID(),
                    "firstName" + i,
                    "lastName" + i,
                    "emailAddress" + i + "@email.com",
                    "phoneNumber" + i,
                    "address" + i));
        }
        return customerList;
    }
}
