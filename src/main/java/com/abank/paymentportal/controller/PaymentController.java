package com.abank.paymentportal.controller;

import com.abank.paymentportal.model.Payment;
import com.abank.paymentportal.model.dto.PaymentCreatedResponseDto;
import com.abank.paymentportal.model.dto.PaymentRequestDto;
import com.abank.paymentportal.service.PaymentService;
import com.abank.paymentportal.service.mapper.PaymentMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @PostMapping
    public ResponseEntity<PaymentCreatedResponseDto> create(
            @RequestBody PaymentRequestDto paymentRequestDto) {
        Payment payment = paymentMapper.toPaymentEntity(paymentRequestDto);
        Payment paymentCreated = paymentService.create(payment);
        PaymentCreatedResponseDto paymentCreatedResponseDto =
                paymentMapper.toPaymentDto(paymentCreated);
        paymentCreatedResponseDto.setPaymentId(paymentCreated.getId());
        return new ResponseEntity<>(paymentCreatedResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/pack-payments")
    public ResponseEntity<List<PaymentCreatedResponseDto>> createdAll(
            @RequestBody List<PaymentRequestDto> paymentRequestDto) {
        List<Payment> payments = paymentRequestDto.stream()
                .map(paymentMapper::toPaymentEntity)
                .collect(Collectors.toList());
        List<Payment> createdPayments = paymentService.createAll(payments);
        List<PaymentCreatedResponseDto> paymentsResponse = new ArrayList<>();
        for (Payment createdPayment : createdPayments) {
            PaymentCreatedResponseDto paymentCreatedResponseDto =
                    paymentMapper.toPaymentDto(createdPayment);
            paymentCreatedResponseDto.setPaymentId(createdPayment.getId());
            paymentsResponse.add(paymentCreatedResponseDto);
        }
        return new ResponseEntity<>(paymentsResponse, HttpStatus.OK);
    }
}
