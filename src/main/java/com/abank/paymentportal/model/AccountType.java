package com.abank.paymentportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_types")
public class AccountType{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameType")
    @Enumerated(EnumType.STRING)
    private NameType nameType;

    public enum NameType {
        CARD_SIMPLE("card/simple");

        private final String type;

        NameType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
