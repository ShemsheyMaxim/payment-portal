package com.abank.paymentportal.model.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentRequestDto {
    @JsonProperty("source_acc_id")
    @NotNull(message = "Source account id can't be null")
    @Min(value = 1, message = "min value for source acc id is 1")
    private Long sourceAccId;
    @JsonProperty("dest_acc_id")
    @NotNull(message = "Dest account id can't be null")
    @Min(value = 1, message = "min value for dest acc id is 1")
    private Long destAccId;
    @Min(value = 1, message = "min sum of transaction is 1")
    private double amount;
    private String reason;
}
