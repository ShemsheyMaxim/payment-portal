package com.abank.paymentportal.model.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentHistoryRequestDto {
    @JsonProperty("payer_id")
    private Long payerId;
    @JsonProperty("recipient_id")
    private Long recipientId;
    @JsonProperty("source_acc_id")
    private Long sourceAccId;
    @JsonProperty("dest_acc_id")
    private Long destAccId;
}
