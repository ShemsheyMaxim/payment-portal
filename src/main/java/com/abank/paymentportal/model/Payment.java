package com.abank.paymentportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "source_acc_id")
    private int sourceAccId;
    @Column(name = "dest_acc_id")
    private int destAccId;
    private double amount;
    private String reason;
}
