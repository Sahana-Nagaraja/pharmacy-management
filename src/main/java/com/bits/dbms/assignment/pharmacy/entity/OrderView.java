package com.bits.dbms.assignment.pharmacy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@Immutable
@Data
@Subselect("SELECT o.order_id, o.store_id, od.product_id FROM pharmacy.order as o " +
                "JOIN order_details as od on o.order_id = od.order_id")
public class OrderView {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column Integer storeId;
    @Column Integer productId;
}
