package com.bits.dbms.assignment.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer product_id;
    private String product_name;
    private Integer category_id;
    private Integer supplier_id;
    private String expiry_duration;
    private Integer threshold_qty;
    private Boolean is_discountable;
    private String created_by;
    private Date created_on;
    private String modified_by;
    private Date modified_on;
}