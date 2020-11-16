package com.easyittech.phabillingservice.client;

import com.easyittech.phabillingservice.dto.PriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "priceClient", url = "http://localhost:8082/api/v1/prices")
public interface PriceClient {
    @GetMapping(value = "/{drug_id}")
    PriceDTO getPriceDetail(@PathVariable("drug_id") Long drugId);
}
