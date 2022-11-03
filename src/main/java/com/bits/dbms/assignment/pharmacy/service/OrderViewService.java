package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.OrderView;
import com.bits.dbms.assignment.pharmacy.repository.OrderViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderViewService {
    private OrderViewRepository orderViewRepository;

    public OrderViewService(OrderViewRepository orderViewRepository) {
        this.orderViewRepository = orderViewRepository;
    }

    public List<OrderView> getOrderView(){
        return orderViewRepository.findAll();
    }
}
