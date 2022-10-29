package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Inventory;
import com.bits.dbms.assignment.pharmacy.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> findAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory findInventoryById(Integer id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        return inventory.orElse(null);
    }

    public Inventory saveInventory(Inventory inventory) {
        inventory.setCreated_on(new Date());
        inventory.setModified_on(null);
        inventory.setModified_by(null);
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory updateInventory(Inventory product) {
        return null;
    }


    public void deleteInventoryById(Integer id) {
        inventoryRepository.deleteById(id);
    }
}
