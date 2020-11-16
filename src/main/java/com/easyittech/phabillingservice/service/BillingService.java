package com.easyittech.phabillingservice.service;

import com.easyittech.phabillingservice.domain.Billing;
import com.easyittech.phabillingservice.domain.BillingDrug;
import com.easyittech.phabillingservice.dto.BillingDTO;

import java.util.List;

public interface BillingService {
    Billing getBillingDetails(Billing billing);

    BillingDTO calculateAmount(List<BillingDrug> billingDrugs);
}
