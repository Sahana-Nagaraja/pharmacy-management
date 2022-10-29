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

@Entity(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer address_id;
    private String address_line1;
    private String address_line2;
    private String address_line3;
    private String city;
    private String state;
    private String country;
    private Integer zip;
    private String created_by;
    private Date created_on;
    private String modified_by;
    private Date modified_on;
}










