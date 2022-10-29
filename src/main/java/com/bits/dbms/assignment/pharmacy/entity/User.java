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

@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;
    private String password;
    private Boolean is_admin;
    private Integer store_id;
    private String name;
    private Integer mobile_no;
    private String email_id;
    private Integer no_of_wrong_attempts;
    private Integer supervisor_id;
    private Date last_login_time;
    private String created_by;
    private Date created_on;
    private String modified_by;
    private Date modified_on;
}