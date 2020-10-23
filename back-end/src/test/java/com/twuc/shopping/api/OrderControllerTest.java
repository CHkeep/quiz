package com.twuc.shopping.api;

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

}
