package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.dto.BillingRequestDTO;
import com.bits.dbms.assignment.pharmacy.entity.Billing;
import com.bits.dbms.assignment.pharmacy.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillingService {

    Billing findById(Integer billingId);

    Billing saveBill(BillingRequestDTO billing);

}
