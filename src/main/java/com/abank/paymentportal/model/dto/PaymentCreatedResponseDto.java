package com.abank.paymentportal.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentCreatedResponseDto {
    @JsonProperty("payment_id")
    private Long paymentId;
}
