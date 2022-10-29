package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Customer;
import com.bits.dbms.assignment.pharmacy.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    @Override
    public Customer findCustomerById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer newCustomer) {
        newCustomer.setCreated_on(new Date());
        newCustomer.setModified_on(null);
        newCustomer.setModified_by(null);
        return customerRepository.save(newCustomer);
    }

    @Override
    public Customer updateCustomer(Customer updateCustomer) {
        Customer customer = findCustomerById(updateCustomer.getCustomer_id());
        if(customer != null) {
            customer.setAddress_id(updateCustomer.getCustomer_id());
            customer.setEmail_id(updateCustomer.getEmail_id());
            customer.setCustomer_dob(updateCustomer.getCustomer_dob());
            customer.setMobile_no(updateCustomer.getMobile_no());
            customer.setName(updateCustomer.getName());
            customer.setModified_on(new Date());
            return customerRepository.save(customer);
        }
        else {
            return saveCustomer(updateCustomer);
        }
    }
}
