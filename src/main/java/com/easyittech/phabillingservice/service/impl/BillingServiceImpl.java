package com.easyittech.phabillingservice.service.impl;

import com.easyittech.phabillingservice.client.PriceClient;
import com.easyittech.phabillingservice.domain.Billing;
import com.easyittech.phabillingservice.domain.BillingDrug;
import com.easyittech.phabillingservice.dto.BillingDTO;
import com.easyittech.phabillingservice.dto.BillingDrugDTO;
import com.easyittech.phabillingservice.dto.PriceDTO;
import com.easyittech.phabillingservice.repository.BillingRepository;
import com.easyittech.phabillingservice.service.BillingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {
    @Autowired
    private PriceClient priceClient;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BillingRepository billingRepository;


    @Override
    public Billing getBillingDetails(Billing billing) {
        BigDecimal totalAmount=calculateTotalAmount(billing.getBillingDrugs());
        billing.setBillAmount(totalAmount);
        billing.setBillDate(new Date());
        return billingRepository.save(billing);
    }

    private BigDecimal calculateTotalAmount(List<BillingDrug> billingDrugDTOS) {
        final BigDecimal[] totalAmount = {new BigDecimal("0.00")};
        final PriceDTO[] priceDTO = new PriceDTO[1];
        billingDrugDTOS.forEach(bill -> {
            priceDTO[0] =priceClient.getPriceDetail(bill.getDrugId());
            totalAmount[0] = totalAmount[0].add(BigDecimal.valueOf(priceDTO[0].getUnitPrice()).multiply(BigDecimal.valueOf(bill.getQuantity())));
        });
        return totalAmount[0];
    }

    @Override
    public BillingDTO calculateAmount(List<BillingDrug> billingDrugs) {
        BillingDTO  billingDTO= new BillingDTO();
        billingDTO.setTotoalAmount(calculateTotalAmount(billingDrugs));
        billingDTO.setBillingDrugs(billingDrugs);
        return billingDTO;
    }
}
