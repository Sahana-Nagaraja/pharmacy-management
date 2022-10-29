package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Customer;

public interface CustomerService {

    Customer findCustomerById(Integer id);

    Customer saveCustomer(Customer newCustomer);

    Customer updateCustomer(Customer updateCustomer);
}
