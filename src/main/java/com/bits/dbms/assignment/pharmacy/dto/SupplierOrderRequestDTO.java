package com.bits.dbms.assignment.pharmacy.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Data
@Builder
public class SupplierOrderRequestDTO {
    private Integer user_id;
    private Integer supplier_id;
    private HashMap<Integer,Integer> productsMap; // Map of product_id and quantity
}
