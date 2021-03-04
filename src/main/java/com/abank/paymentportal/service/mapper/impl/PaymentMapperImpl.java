package com.abank.paymentportal.service.mapper.impl;

import com.abank.paymentportal.model.Payment;
import com.abank.paymentportal.model.dto.PaymentCreatedResponseDto;
import com.abank.paymentportal.model.dto.PaymentRequestDto;
import com.abank.paymentportal.service.mapper.PaymentMapper;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapperImpl implements PaymentMapper {
    @Override
    public PaymentCreatedResponseDto toPaymentDto(Payment payment) {
        PaymentCreatedResponseDto paymentCreatedResponseDto = new PaymentCreatedResponseDto();
        paymentCreatedResponseDto.setPaymentId(paymentCreatedResponseDto.getPaymentId());
        return paymentCreatedResponseDto;
    }

    @Override
    public Payment toPaymentEntity(PaymentRequestDto paymentRequestDto) {
        Payment payment = new Payment();
        payment.setSourceAccId(paymentRequestDto.getSourceAccId());
        payment.setDestAccId(paymentRequestDto.getDestAccId());
        payment.setAmount(paymentRequestDto.getAmount());
        payment.setReason(paymentRequestDto.getReason());
        return payment;
    }
}
