package com.bits.dbms.assignment.pharmacy.entity;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@Immutable
@Data
@Subselect("SELECT o.order_id, o.store_id, s.supplier_name FROM pharmacy.order as o " +
                "JOIN supplier as s on o.supplier_id = s.supplier_id")
public class OrderView {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column Long storeId;
    @Column String supplierName;
}
