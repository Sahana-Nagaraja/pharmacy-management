package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.dto.SupplierOrderRequestDTO;
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
        supplier.setCreatedOn(new Date());
        supplier.setModifiedOn(null);
        supplier.setModifiedBy(null);
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier updateSupplier(Supplier supplier, Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier supplierDB = optionalSupplier.get();
            if (Objects.nonNull(supplier.getSupplierName())) {
                supplierDB.setSupplierName(supplier.getSupplierName());
            }
            if (Objects.nonNull(supplier.getAddressId())) {
                supplierDB.setAddressId(supplier.getAddressId());
            }
            if (Objects.nonNull(supplier.getMobileNo())) {
                supplierDB.setMobileNo(supplier.getMobileNo());
            }
            if (Objects.nonNull(supplier.getEmailId())) {
                supplierDB.setEmailId(supplier.getEmailId());
            }
            supplierDB.setModifiedOn(new Date());
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
        Supplier supplier = supplierRepository.getReferenceById(orderRequestDTO.getSupplier_id());

        return new HashMap<>();
    }
}
