package com.bits.dbms.assignment.pharmacy.billing;

import com.bits.dbms.assignment.pharmacy.entity.Billing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillingService {

    Supplier findById(Integer billing_id);

    Supplier saveBill(Billing billing);

}
