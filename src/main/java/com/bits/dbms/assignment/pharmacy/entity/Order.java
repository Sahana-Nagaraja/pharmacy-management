package com.bits.dbms.assignment.pharmacy.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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
    @Column(name = "order_id")
    private Long orderId;
    private LocalDateTime orderDate;
    private String orderStatus;
    private Integer storeId;
    private Integer supplierId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderObj")
    private Set<OrderItem> orderItems;
    private Integer createdBy;
    private LocalDateTime deliveredOn;
    @CreationTimestamp
    private LocalDateTime createdOn;
    private Integer modifiedBy;
    @UpdateTimestamp
    private LocalDateTime modifiedOn;
}