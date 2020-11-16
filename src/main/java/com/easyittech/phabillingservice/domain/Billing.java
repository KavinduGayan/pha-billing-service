package com.easyittech.phabillingservice.domain;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "pha_billing")
@Getter@Setter
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billing_id")
    private Long id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "mobile_no")
    private long mobileNo;
    @Column(name = "bill_amount")
    private BigDecimal billAmount;
    @Column(name = "bill_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billDate;
    @OneToMany(mappedBy = "billing", cascade = CascadeType.ALL)
    private List<BillingDrug> billingDrugs = new ArrayList<>();

    public void setBillingDrugs(List<BillingDrug> billingDrugs) {
        for (BillingDrug drug:billingDrugs) {
            drug.setBilling(this);
        }
        this.billingDrugs = billingDrugs;
    }
}
