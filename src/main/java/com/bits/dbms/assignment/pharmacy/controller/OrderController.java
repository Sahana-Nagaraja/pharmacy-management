package com.bits.dbms.assignment.pharmacy.controller;

import com.bits.dbms.assignment.pharmacy.dto.OrderRequestDTO;
import com.bits.dbms.assignment.pharmacy.entity.Order;
import com.bits.dbms.assignment.pharmacy.entity.OrderView;
import com.bits.dbms.assignment.pharmacy.service.OrderCountService;
import com.bits.dbms.assignment.pharmacy.service.OrderService;
import com.bits.dbms.assignment.pharmacy.service.OrderViewService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderViewService orderViewService;
    private final OrderCountService orderCountService;

    public OrderController(OrderService orderService, OrderViewService orderViewService, OrderCountService orderCountService) {
        this.orderService = orderService;
        this.orderViewService = orderViewService;
        this.orderCountService = orderCountService;
    }


    @GetMapping("/{order_id}")
    public Order findOrderById(@PathVariable(value = "order_id") Long orderId) {
        return orderService.findById(orderId);
    }

    @PostMapping
    public Order saveOrder(@Validated @RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.createOrder(orderRequestDTO);
    }


    @GetMapping("/count/{storeId}")
    public Long findOrderCount(@PathVariable(name = "storeId") Long storeId) {
        return orderCountService.getOrderCount(storeId);
    }

    @GetMapping("/view")
    public List<OrderView> getOrderView() {
        return orderViewService.getOrderView();
    }
}
