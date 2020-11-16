package com.easyittech.phabillingservice.dto;

import com.easyittech.phabillingservice.domain.BillingDrug;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter@Setter
public class BillingDTO {

    private BigDecimal totoalAmount;
    private List<BillingDrug> billingDrugs;
}
