package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> findAllInventory();

    Inventory findInventoryById(Integer id);

    Inventory saveInventory(Inventory product);

    Inventory updateInventory(Inventory product);

    void deleteInventoryById(Integer id);
}
