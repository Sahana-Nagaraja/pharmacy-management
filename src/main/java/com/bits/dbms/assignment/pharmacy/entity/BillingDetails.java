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

@Entity(name = "billing_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer billing_details_id;
    private Integer billing_id;
    private Integer inventory_id;
    private Integer quantity;
    private String created_by;
    private Date created_on;
    private String modified_by;
    private Date modified_on;
}












