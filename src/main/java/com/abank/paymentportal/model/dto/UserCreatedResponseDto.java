package com.abank.paymentportal.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserCreatedResponseDto {
    @JsonProperty(value = "client_id")
    private Long id;
}
