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

@Entity(name = "config")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer config_id;
    private String config_category;
    private String key;
    private String value;
    private String created_by;
    @CreationTimestamp
    private Date created_on;
    private String modified_by;
    @UpdateTimestamp
    private Date modified_on;
}








