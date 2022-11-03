package com.bits.dbms.assignment.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order")
@NamedStoredProcedureQuery(
        name = "get_total_orders",
        procedureName = "get_total_orders",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "store_id_in"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "order_count")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDateTime orderDate;
    private String orderStatus;
    private Integer storeId;
    private Integer supplierId;
    private Integer createdBy;
    private LocalDateTime deliveredOn;
    @CreationTimestamp
    private LocalDateTime createdOn;
    private Integer modifiedBy;
    @UpdateTimestamp
    private LocalDateTime modifiedOn;
}