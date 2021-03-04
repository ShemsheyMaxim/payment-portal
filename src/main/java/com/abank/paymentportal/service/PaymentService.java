package com.abank.paymentportal.service;

import com.abank.paymentportal.model.Payment;
import java.util.List;

public interface PaymentService {
    Payment create(Payment payment);

    List<Payment> createAll(List<Payment> payments);

    Payment getById(Long paymentId);

    Payment getPaymentBySourceAccIdAndDestAccId(Long sourceAccId, Long destAccId);
}
