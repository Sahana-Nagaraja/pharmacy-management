package com.bits.dbms.assignment.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "billing_details")
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
    @CreationTimestamp
    private Date created_on;
    private String modified_by;
    @UpdateTimestamp
    private Date modified_on;
}












