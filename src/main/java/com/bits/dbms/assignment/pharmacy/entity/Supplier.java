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

@Entity(name = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer supplier_id;
    private String supplier_name;
    private Integer address_id;
    private Integer mobile_no;
    private String email_id;
    private String created_by;
    @CreationTimestamp
    private Date created_on;
    private String modified_by;
    @UpdateTimestamp
    private Date modified_on;
}
