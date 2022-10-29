package com.bits.dbms.assignment.pharmacy.controller;

import com.bits.dbms.assignment.pharmacy.entity.Customer;
import com.bits.dbms.assignment.pharmacy.service.CustomerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") Integer id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping
    public Customer updateCustomer(@Validated @RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }
}
