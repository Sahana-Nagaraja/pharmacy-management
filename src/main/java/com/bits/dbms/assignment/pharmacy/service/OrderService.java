package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.dto.OrderRequestDTO;
import com.bits.dbms.assignment.pharmacy.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    Order findById(Long orderId);

    Order createOrder(OrderRequestDTO order);

}
