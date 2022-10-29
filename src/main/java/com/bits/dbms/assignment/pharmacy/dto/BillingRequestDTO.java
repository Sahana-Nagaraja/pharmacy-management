package com.bits.dbms.assignment.pharmacy.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;

@Data
@Builder
public class BillingRequestDTO {
    private Integer customerId;
    private String storeId;
    private String offerId;
    private Integer discountAmount;
    private String paymentMode;
    private Date billingDate;
    private HashMap<Integer, Integer> inventoryQtyMap;
}
