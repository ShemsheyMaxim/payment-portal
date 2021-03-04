package com.abank.paymentportal.model.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PaymentHistoryResponseDto {
    @JsonProperty("payment_id")
    private Long paymentId;
    private LocalDateTime timestamp;
    @JsonProperty("src_acc_num")
    private String srcAccNum;
    @JsonProperty("dest_acc_num")
    private String destAccNum;
    private double amount;
    private Payer payer;
    private Recipient recipient;

    @Data
    public static class Payer {
        private String firstName;
        private String lastName;
    }

    @Data
    public static class Recipient {
        private String firstName;
        private String lastName;
    }
}
