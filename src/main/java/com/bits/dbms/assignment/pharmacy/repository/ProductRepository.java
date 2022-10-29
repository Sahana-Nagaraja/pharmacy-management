package com.bits.dbms.assignment.pharmacy.repository;

import com.bits.dbms.assignment.pharmacy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
