package com.bits.dbms.assignment.pharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private Integer productId;
    private Integer quantity;
    private Integer storeId;
    private Integer supplierId;
    private Integer createdBy;
    private Integer modifiedBy;
}