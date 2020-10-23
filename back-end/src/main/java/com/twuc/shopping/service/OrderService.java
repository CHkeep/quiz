package com.twuc.shopping.service;

import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.po.StorePO;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    StoreRepository storeRepository;

    public ResponseEntity addOrder(int storeId) {
        StorePO storePO = storeRepository.findById(storeId).orElseThrow(RuntimeException::new);
        OrderPO orderPO = OrderPO.builder()
                .price(storePO.getPrice()).storePO(storePO).build();
        orderRepository.save(orderPO);
        return  ResponseEntity.ok().build();

    }

    public ResponseEntity deleteOrder(int storeId) {
        orderRepository.deleteAllByStorePO_Id(storeId);
        return ResponseEntity.ok().build();
    }
}