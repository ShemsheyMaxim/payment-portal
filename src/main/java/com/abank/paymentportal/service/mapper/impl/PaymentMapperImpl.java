package com.abank.paymentportal.service.mapper.impl;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.model.Payment;
import com.abank.paymentportal.model.dto.payment.PaymentCreatedResponseDto;
import com.abank.paymentportal.model.dto.payment.PaymentRequestDto;
import com.abank.paymentportal.model.dto.payment.PaymentResponseDto;
import com.abank.paymentportal.service.AccountService;
import com.abank.paymentportal.service.mapper.PaymentMapper;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentMapperImpl implements PaymentMapper {
    private final AccountService accountService;

    @Override
    public PaymentCreatedResponseDto toPaymentCreatedDto(Payment payment) {
        PaymentCreatedResponseDto paymentCreatedResponseDto = new PaymentCreatedResponseDto();
        paymentCreatedResponseDto.setPaymentId(paymentCreatedResponseDto.getPaymentId());
        return paymentCreatedResponseDto;
    }

    @Override
    public Payment toPaymentEntity(PaymentRequestDto paymentRequestDto) {
        Payment payment = new Payment();
        payment.setStatus("ok");
        payment.setSourceAccId(paymentRequestDto.getSourceAccId());
        payment.setDestAccId(paymentRequestDto.getDestAccId());
        Account accountPayer = accountService.getById(payment.getSourceAccId());
        if (accountPayer.getBalance() - paymentRequestDto.getAmount() < 0) {
            payment.setStatus("error");
        }
        payment.setAmount(paymentRequestDto.getAmount());
        payment.setReason(paymentRequestDto.getReason());
        payment.setTimestamp(LocalDateTime.now());
        return payment;
    }

    @Override
    public PaymentResponseDto toPaymentDto(Payment payment) {
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setPaymentId(payment.getId());
        paymentResponseDto.setStatus(payment.getStatus());
        return paymentResponseDto;
    }
}
