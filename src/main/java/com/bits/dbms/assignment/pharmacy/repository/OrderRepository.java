package com.bits.dbms.assignment.pharmacy.repository;

import com.bits.dbms.assignment.pharmacy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
