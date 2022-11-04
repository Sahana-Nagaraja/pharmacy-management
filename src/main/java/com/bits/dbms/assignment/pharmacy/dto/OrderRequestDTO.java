package com.bits.dbms.assignment.pharmacy.dto;

import com.bits.dbms.assignment.pharmacy.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private Set<OrderItem> orderItems;
    private Integer storeId;
    private Integer supplierId;
    private Integer createdBy;
    private Integer modifiedBy;
}