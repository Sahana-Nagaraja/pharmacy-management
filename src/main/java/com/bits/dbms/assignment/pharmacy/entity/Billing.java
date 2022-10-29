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

@Entity(name = "billing")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer billing_id;
    private Integer customer_id;
    private String store_id;
    private String offer_id;
    private Integer discount_amount;
    private Integer net_amount;
    private String payment_mode;
    private Date billing_date;
    private String created_by;
    @CreationTimestamp private Date created_on;
    private String modified_by;
    @UpdateTimestamp private Date modified_on;
}









