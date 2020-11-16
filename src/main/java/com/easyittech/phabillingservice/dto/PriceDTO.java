package com.easyittech.phabillingservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter@Setter
public class PriceDTO {
    private Long id;
    private double unitPrice;
    private double batchPrice;
    private Long batchCount;
    private String status;
    private Long drugId;
    private Date timeStamp;
}
