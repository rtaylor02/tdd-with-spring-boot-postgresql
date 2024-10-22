package com.rtaylor02.tdd_with_spring_boot_postgresql.dao;


import com.rtaylor02.tdd_with_spring_boot_postgresql.service.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerDao extends CrudRepository<CustomerEntity, UUID> {
}
