package com.bits.dbms.assignment.pharmacy.billing;

import com.bits.dbms.assignment.pharmacy.entity.Billing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillingService {

    Billing findById(Integer billing_id);

    Billing saveBill(Billing billing);

}
