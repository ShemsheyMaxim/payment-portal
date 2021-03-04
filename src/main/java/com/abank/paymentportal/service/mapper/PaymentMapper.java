package com.abank.paymentportal.service.mapper;

import com.abank.paymentportal.model.Payment;
import com.abank.paymentportal.model.dto.payment.PaymentCreatedResponseDto;
import com.abank.paymentportal.model.dto.payment.PaymentRequestDto;
import com.abank.paymentportal.model.dto.payment.PaymentResponseDto;

public interface PaymentMapper {
    PaymentCreatedResponseDto toPaymentCreatedDto(Payment payment);

    Payment toPaymentEntity(PaymentRequestDto paymentRequestDto);

    PaymentResponseDto toPaymentDto(Payment payment);
}
