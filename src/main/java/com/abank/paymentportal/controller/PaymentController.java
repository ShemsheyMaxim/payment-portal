package com.abank.paymentportal.controller;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.model.Payment;
import com.abank.paymentportal.model.User;
import com.abank.paymentportal.model.dto.payment.PaymentCreatedResponseDto;
import com.abank.paymentportal.model.dto.payment.PaymentHistoryRequestDto;
import com.abank.paymentportal.model.dto.payment.PaymentHistoryResponseDto;
import com.abank.paymentportal.model.dto.payment.PaymentRequestDto;
import com.abank.paymentportal.model.dto.payment.PaymentResponseDto;
import com.abank.paymentportal.service.AccountService;
import com.abank.paymentportal.service.PaymentService;
import com.abank.paymentportal.service.UserService;
import com.abank.paymentportal.service.mapper.PaymentMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final UserService userService;
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<PaymentCreatedResponseDto> create(
            @RequestBody @Valid PaymentRequestDto paymentRequestDto) {
        Payment payment = paymentMapper.toPaymentEntity(paymentRequestDto);
        Payment paymentCreated = paymentService.create(payment);
        PaymentCreatedResponseDto paymentCreatedResponseDto =
                paymentMapper.toPaymentCreatedDto(paymentCreated);
        paymentCreatedResponseDto.setPaymentId(paymentCreated.getId());
        return new ResponseEntity<>(paymentCreatedResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/pack-payments")
    public ResponseEntity<List<PaymentResponseDto>> createdAll(
            @RequestBody @Valid List<PaymentRequestDto> paymentRequestDto) {
        List<Payment> payments = paymentRequestDto.stream()
                .map(paymentMapper::toPaymentEntity)
                .collect(Collectors.toList());
        List<Payment> createdPayments = paymentService.createAll(payments);
        List<PaymentResponseDto> paymentsResponse = new ArrayList<>();
        for (Payment createdPayment : createdPayments) {
            PaymentResponseDto paymentResponseDto = paymentMapper.toPaymentDto(createdPayment);
            paymentsResponse.add(paymentResponseDto);
        }
        return new ResponseEntity<>(paymentsResponse, HttpStatus.OK);
    }

    @GetMapping("/history")
    public ResponseEntity<PaymentHistoryResponseDto> getHistoryPaymentForUser(
            @RequestBody PaymentHistoryRequestDto paymentHistoryRequestDto) {
        PaymentHistoryResponseDto paymentHistoryResponseDto = new PaymentHistoryResponseDto();
        Long payerId = paymentHistoryRequestDto.getPayerId();
        User userPayerById = userService.getById(payerId);
        PaymentHistoryResponseDto.Payer payer = new PaymentHistoryResponseDto.Payer();
        payer.setFirstName(userPayerById.getFirstName());
        payer.setLastName(userPayerById.getLastName());
        paymentHistoryResponseDto.setPayer(payer);
        Long recipientId = paymentHistoryRequestDto.getRecipientId();
        User userRecipientId = userService.getById(recipientId);
        PaymentHistoryResponseDto.Recipient recipient = new PaymentHistoryResponseDto.Recipient();
        recipient.setFirstName(userRecipientId.getFirstName());
        recipient.setLastName(userPayerById.getLastName());
        paymentHistoryResponseDto.setRecipient(recipient);
        Payment paymentBySourceAccIdAndDestAccId =
                paymentService.getPaymentBySourceAccIdAndDestAccId(paymentHistoryRequestDto
                        .getSourceAccId(), paymentHistoryRequestDto.getDestAccId());
        paymentHistoryResponseDto.setPaymentId(paymentBySourceAccIdAndDestAccId.getId());
        paymentHistoryResponseDto.setTimestamp(paymentBySourceAccIdAndDestAccId.getTimestamp());
        Account byIdPayer = accountService.getById(paymentBySourceAccIdAndDestAccId
                .getSourceAccId());
        paymentHistoryResponseDto.setSrcAccNum(byIdPayer.getAccountNum());
        Account byIdRecipient = accountService.getById(paymentBySourceAccIdAndDestAccId
                .getDestAccId());
        paymentHistoryResponseDto.setDestAccNum(byIdRecipient.getAccountNum());
        paymentHistoryResponseDto.setAmount(paymentBySourceAccIdAndDestAccId.getAmount());
        return new ResponseEntity<>(paymentHistoryResponseDto, HttpStatus.OK);
    }
}
