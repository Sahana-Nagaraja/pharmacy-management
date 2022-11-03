package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.repository.OrderCountRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderCountService {
    private OrderCountRepository orderCountRepository;

    public OrderCountService(OrderCountRepository orderCountRepository) {
        this.orderCountRepository = orderCountRepository;
    }

    public Long getOrderCount(Long storeId){
        return orderCountRepository.getOrderCount(storeId);
    }

}
