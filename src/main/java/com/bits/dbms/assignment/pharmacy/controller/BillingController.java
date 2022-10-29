package com.bits.dbms.assignment.pharmacy.controller;

import com.bits.dbms.assignment.pharmacy.entity.Billing;
import com.bits.dbms.assignment.pharmacy.service.BillingService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    private final BillingService billingService;

    public billingController(BillingService billingService) {
        this.billingService = billingService;
    }


    @GetMapping("/{billing_id}")
    public Billing findBillById(@PathVariable(value = "billing_id") Integer billing_id) {
        return billingService.findBillById(billing_id);
    }

    @PostMapping
    public Billing saveBill(@Validated @RequestBody Billing billing) {
        return billingService.saveBill(billing);
    }

  /*  @PutMapping
    public Supplier updateSupplier(@Validated @RequestBody Supplier supplier, Integer id) {
        return supplierService.updateSupplier(supplier, id);
    }*/

}
