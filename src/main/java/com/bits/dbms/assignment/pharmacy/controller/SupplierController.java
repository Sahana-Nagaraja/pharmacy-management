package com.bits.dbms.assignment.pharmacy.controller;

import com.bits.dbms.assignment.pharmacy.entity.Supplier;
import com.bits.dbms.assignment.pharmacy.service.SupplierService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> findAllSuppliers() {
        return supplierService.findAllSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier findSupplierById(@PathVariable(value = "id") Integer id) {
        return supplierService.findSupplierById(id);
    }

    @PostMapping
    public Supplier saveSupplier(@Validated @RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @PutMapping
    public Supplier updateSupplier(@Validated @RequestBody Supplier supplier, Integer id) {
        return supplierService.updateSupplier(supplier, id);
    }

    @DeleteMapping("/{id}")
    public String deleteSupplierById(@PathVariable(value = "id") Integer id) {
        supplierService.deleteSupplierById(id);
        return "Deleted Successfully";
    }
}
