package com.easyittech.phabillingservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pha_billing_drug")
@Getter@Setter
public class BillingDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billing_drug_id")
    private Long id;
    @Column(name = "drug_id")
    private Long drugId;
    private Long quantity;
    @ManyToOne(optional = false)
    @JoinColumn(name = "billing_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Billing billing;
}
