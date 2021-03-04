package com.abank.paymentportal.repository;

import com.abank.paymentportal.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
