package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {

    List<Supplier> findAllSuppliers();

    Supplier findSupplierById(Integer id);

    Supplier saveSupplier(Supplier supplier);

    Supplier updateSupplier(Supplier supplier, Integer id);

    void deleteSupplierById(Integer id);
}
