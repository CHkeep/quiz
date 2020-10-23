package com.twuc.shopping.api;

import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.po.StorePO;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    StoreRepository storeRepository;
    @Autowired
    OrderRepository orderRepository;

    OrderPO orderPO;


    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();
        storeRepository.deleteAll();
    }


    @Test
    public void should_add_order() throws Exception {
       StorePO storePO = StorePO.builder().storeName("可乐").price(2.5).storeUnit("瓶").picture("abc/ef").build();
       storeRepository.save(storePO);
        mockMvc.perform(post("/order").param("storeId","1"))
                .andExpect(status().isOk());

        assertEquals(1, storeRepository.findAll().size());
    }

    @Test
    public void should_delete_order_when_exist() throws Exception {
        StorePO storePO = StorePO.builder().storeName("可乐").price(4).storeUnit("大瓶").picture("abc/ef").build();
        storeRepository.save(storePO);
        for (int i = 0; i < 3; i++) {
            orderPO = OrderPO.builder().price(storePO.getPrice()).storePO(storePO).build();
            orderRepository.save(orderPO);
        }

        StorePO storePO1 = StorePO.builder().storeName("雪碧").price(3).storeUnit("瓶").picture("abc/gh").build();
        storeRepository.save(storePO1);
        for (int i = 0; i < 3; i++) {
            orderPO = OrderPO.builder().price(storePO1.getPrice()).storePO(storePO1).build();
            orderRepository.save(orderPO);
        }

        mockMvc.perform(post("/order/delete").param("storeId","2"))
                .andExpect(status().isOk());

        assertEquals(3, orderRepository.findAll().size());
    }


}
