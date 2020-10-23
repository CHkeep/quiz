package com.twuc.shopping.api;

import com.twuc.shopping.domain.Order;
import com.twuc.shopping.po.StorePO;
import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity addOrder(@RequestParam int storeId){
        return orderService.addOrder(storeId);

    }

}
