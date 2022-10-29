package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Billing;
import com.bits.dbms.assignment.pharmacy.repository.BillingRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;

    public BillingServiceImpl(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }


    @Override
    public Supplier findBillById(Integer billing_id) {
        Optional<Billing> optionalBilling = billingRepository.findById(billing_id);
        return optionalBilling.orElse(null);
    }

    @Override
    public Supplier saveBill(Billing billing) {
        supplier.setCreated_on(new Date());
        supplier.setModified_on(null);
        supplier.setModified_by(null);
        return billingRepository.save(billing);
    }

}
