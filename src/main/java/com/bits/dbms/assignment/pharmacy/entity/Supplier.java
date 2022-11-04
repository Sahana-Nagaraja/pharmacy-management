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
@Table(name = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer supplierId;
    private String supplierName;
    private Integer addressId;
    private Integer mobileNo;
    private String emailId;
    private String createdBy;
    @CreationTimestamp
    private Date createdOn;
    private String modifiedBy;
    @UpdateTimestamp
    private Date modifiedOn;
}
