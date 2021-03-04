package com.abank.paymentportal.service.mapper;

import com.abank.paymentportal.model.Payment;
import com.abank.paymentportal.model.dto.PaymentCreatedResponseDto;
import com.abank.paymentportal.model.dto.PaymentRequestDto;

public interface PaymentMapper {
    PaymentCreatedResponseDto toPaymentDto(Payment payment);

    Payment toPaymentEntity(PaymentRequestDto paymentRequestDto);
}
