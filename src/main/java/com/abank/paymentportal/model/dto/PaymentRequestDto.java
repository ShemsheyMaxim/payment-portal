package com.abank.paymentportal.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Min;
import lombok.Data;

@Data
public class PaymentRequestDto {
    private Long id;
    @JsonProperty("source_acc_id")
    private int sourceAccId;
    @JsonProperty("dest_acc_id")
    private int destAccId;
    @Min(1)
    private double amount;
    private String reason;
}
