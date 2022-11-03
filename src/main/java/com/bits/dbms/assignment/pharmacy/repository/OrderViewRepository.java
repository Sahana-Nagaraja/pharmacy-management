package com.bits.dbms.assignment.pharmacy.repository;

import com.bits.dbms.assignment.pharmacy.entity.OrderView;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface OrderViewRepository extends ReadOnlyRepository<OrderView, Long> {
    List<OrderView> findAll();
}