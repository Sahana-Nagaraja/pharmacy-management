package com.bits.dbms.assignment.pharmacy.repository;

import com.bits.dbms.assignment.pharmacy.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderItem, Long> {

}
