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

@Entity(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customer_id;
    private String name;
    private String email_id;
    private String mobile_no;
    private Date customer_dob;
    private Integer address_id;
    private String created_by;
    @CreationTimestamp
    private Date created_on;
    private String modified_by;
    @UpdateTimestamp
    private Date modified_on;
}















