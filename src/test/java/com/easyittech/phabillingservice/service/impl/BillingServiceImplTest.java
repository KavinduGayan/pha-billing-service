package com.easyittech.phabillingservice.service.impl;

import com.easyittech.phabillingservice.domain.Billing;
import com.easyittech.phabillingservice.domain.BillingDrug;
import com.easyittech.phabillingservice.dto.BillingDTO;
import com.easyittech.phabillingservice.dto.BillingDrugDTO;
import com.easyittech.phabillingservice.repository.BillingRepository;
import com.easyittech.phabillingservice.service.BillingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BillingServiceImplTest {
    @Autowired
    private com.easyittech.phabillingservice.service.BillingService billingService;
    @Autowired
    private BillingRepository billingRepository;

    @Test
    void getBillingDetails() {
        Billing billingDTO=new Billing();
        billingDTO.setCustomerName("kavindu");
        billingDTO.setMobileNo(711438879l);
        BillingDrug billingDrugDTO= new BillingDrug();
        billingDrugDTO.setDrugId(1l);
        billingDrugDTO.setQuantity(30l);
        BillingDrug billingDrugDTO1= new BillingDrug();
        billingDrugDTO1.setDrugId(2l);
        billingDrugDTO1.setQuantity(30l);
        List<BillingDrug> drugDTOS = new ArrayList<>();
        drugDTOS.add(billingDrugDTO);
        drugDTOS.add(billingDrugDTO1);
        billingDTO.setBillingDrugs(drugDTOS);
        billingService.getBillingDetails(billingDTO);
    }
}