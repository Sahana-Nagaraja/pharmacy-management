package com.bits.dbms.assignment.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order_details_id;
    private Integer order_id;
    private Integer product_id;
    private Integer quantity;
    private Integer unit_price;
    private String created_by;
    @CreationTimestamp
    private Date created_on;
    private String modified_by;
    @UpdateTimestamp
    private Date modified_on;
}














