package com.abank.paymentportal.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PaymentResponseDto {
    @JsonProperty("payment_id")
    private Long paymentId;
    @JsonProperty("status")
    private HttpStatus httpStatus;
}
