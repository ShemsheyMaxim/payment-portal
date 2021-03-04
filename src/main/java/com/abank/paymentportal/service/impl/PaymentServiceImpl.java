package com.abank.paymentportal.service.impl;

import com.abank.paymentportal.model.Payment;
import com.abank.paymentportal.repository.PaymentRepository;
import com.abank.paymentportal.service.PaymentService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> createAll(List<Payment> payments) {
        return paymentRepository.saveAll(payments);
    }

    @Override
    public Payment getById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() ->
                new EntityNotFoundException("Payment by id " + paymentId + " not found in table"));
    }

    @Override
    public Payment getPaymentBySourceAccIdAndDestAccId(Long sourceAccId, Long destAccId) {
        return paymentRepository.getPaymentBySourceAccIdAndDestAccId(sourceAccId, destAccId)
                .orElseThrow(() -> new EntityNotFoundException("Error with find payment in "
                        + "table by sourceAccId " + sourceAccId + " and destAccId " + destAccId));
    }
}
