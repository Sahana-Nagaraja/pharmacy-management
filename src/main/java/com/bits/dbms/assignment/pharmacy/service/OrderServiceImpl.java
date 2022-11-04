package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.dto.OrderRequestDTO;
import com.bits.dbms.assignment.pharmacy.entity.Order;
import com.bits.dbms.assignment.pharmacy.entity.OrderItem;
import com.bits.dbms.assignment.pharmacy.repository.OrderDetailsRepository;
import com.bits.dbms.assignment.pharmacy.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
        Set<OrderItem> orderItems = getOrderItemsWithPrice(orderRequestDTO.getOrderItems());
        for (OrderItem oi : orderItems) {
            oi.setOrderObj(savedOrder);
        }
        List<OrderItem> savedOrderItemsList = orderDetailsRepository.saveAll(orderItems);
        Set<OrderItem> savedOrderItems = new HashSet<>(savedOrderItemsList);
        savedOrder.setOrderItems(savedOrderItems);
        return savedOrder;
    }

    private Set<OrderItem> getOrderItemsWithPrice(Set<OrderItem> orderItems) {
        orderItems.forEach(oi -> oi.setUnitPrice(fetchUnitPrice(oi.getProductId())));
        return orderItems;
    }

    private Integer fetchUnitPrice(Integer productId) {
        //fetch from inventory
        return ThreadLocalRandom.current().nextInt(100, 1000);
    }
}
