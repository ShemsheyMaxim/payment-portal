package com.abank.paymentportal.repository;

import com.abank.paymentportal.model.Payment;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT p FROM Payment p WHERE p.sourceAccId = :sourceAccId "
            + "AND p.destAccId = :destAccId")
    Optional<Payment> getPaymentBySourceAccIdAndDestAccId(Long sourceAccId, Long destAccId);
}
