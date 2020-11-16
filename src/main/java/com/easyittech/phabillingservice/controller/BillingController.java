package com.easyittech.phabillingservice.controller;

import com.easyittech.phabillingservice.domain.Billing;
import com.easyittech.phabillingservice.domain.BillingDrug;
import com.easyittech.phabillingservice.dto.BillingDTO;
import com.easyittech.phabillingservice.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/billing-service")
public class BillingController {
    @Autowired
    private BillingService billingService;
    @PostMapping("/billing")
    public ResponseEntity<Billing> getBillingDetails(@RequestBody Billing billing){
        return ResponseEntity.ok().body(billingService.getBillingDetails(billing));
    }
    @GetMapping(value = "/calculate-amount",produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillingDTO> calculateAmount(@RequestBody BillingDTO billingDTO) {
        return ResponseEntity.ok().body(billingService.calculateAmount(billingDTO.getBillingDrugs()));
    }
}
