package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.dto.SupplierOrderRequestDTO;
import com.bits.dbms.assignment.pharmacy.entity.Product;
import com.bits.dbms.assignment.pharmacy.entity.Supplier;
import com.bits.dbms.assignment.pharmacy.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> findAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findSupplierById(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        return optionalSupplier.orElse(null);
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        supplier.setCreated_on(new Date());
        supplier.setModified_on(null);
        supplier.setModified_by(null);
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier updateSupplier(Supplier supplier, Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier supplierDB = optionalSupplier.get();
            if (Objects.nonNull(supplier.getSupplier_name())) {
                supplierDB.setSupplier_name(supplier.getSupplier_name());
            }
            if (Objects.nonNull(supplier.getAddress_id())) {
                supplierDB.setAddress_id(supplier.getAddress_id());
            }
            if (Objects.nonNull(supplier.getMobile_no())) {
                supplierDB.setMobile_no(supplier.getMobile_no());
            }
            if (Objects.nonNull(supplier.getEmail_id())) {
                supplierDB.setEmail_id(supplier.getEmail_id());
            }
            supplierDB.setModified_on(new Date());
            supplierRepository.save(supplierDB);
            return supplierDB;
        } else {
            return saveSupplier(supplier);
        }
    }

    @Override
    public void deleteSupplierById(Integer id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public HashMap<Integer,Integer> orderProductsFromSupplier(SupplierOrderRequestDTO orderRequestDTO) {
        // logic to fetch products from supplier
        return new HashMap<>();
    }
}
