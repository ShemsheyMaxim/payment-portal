package com.abank.paymentportal.model.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentResponseDto {
    @JsonProperty("payment_id")
    private Long paymentId;
    @JsonProperty("status")
    private String status;
}
