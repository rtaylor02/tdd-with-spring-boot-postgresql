package com.rtaylor02.tdd_with_spring_boot_postgresql.model;

import java.util.UUID;

public record Customer(UUID customerId, String firstName, String lastName, String emailAddress,
                       String phoneNumber, String address) {
}
