package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.dto.OrderRequestDTO;
import com.bits.dbms.assignment.pharmacy.entity.Order;
import com.bits.dbms.assignment.pharmacy.entity.OrderDetails;
import com.bits.dbms.assignment.pharmacy.repository.OrderDetailsRepository;
import com.bits.dbms.assignment.pharmacy.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private final InventoryService inventoryService;
    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderServiceImpl(InventoryService inventoryService, OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository) {
        this.inventoryService = inventoryService;
        this.orderRepository = orderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }


    @Override
    public Order findById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }

    @Override
    @Transactional
    public Order createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = Order.builder()
                .orderDate(LocalDateTime.now())
                .orderStatus("Created")
                .storeId(orderRequestDTO.getStoreId())
                .supplierId(orderRequestDTO.getSupplierId())
                .createdBy(orderRequestDTO.getCreatedBy())
                .modifiedBy(orderRequestDTO.getModifiedBy())
                .build();
        Order savedOrder = orderRepository.save(order);
        OrderDetails orderDetails = OrderDetails.builder()
                .orderId(savedOrder.getOrderId())
                .productId(orderRequestDTO.getProductId())
                .quantity(orderRequestDTO.getQuantity())
                .unitPrice(fetchUnitPrice(orderRequestDTO.getProductId()))
                .build();
        orderDetailsRepository.save(orderDetails);
        return savedOrder;
    }

    private Integer fetchUnitPrice(Integer product_id) {
        //fetch from inventory
        return 100;
    }
}
