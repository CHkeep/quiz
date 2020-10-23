package com.twuc.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Store;
import com.twuc.shopping.po.StorePO;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StoreControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    StoreRepository storeRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        storeRepository.deleteAll();
    }


    @Test
    public void should_add_store() throws Exception {
        Store store = new Store("可乐", 1, "瓶", "url");
        String jsonString = objectMapper.writeValueAsString(store);
        mockMvc.perform(post("/store").content(jsonString)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(1.0, storeRepository.findAll().get(0).getPrice());
    }


    @Test
    public void should_get_store() throws Exception {
        StorePO storePO1 = StorePO.builder().picture("a/c").storeUnit("瓶").price(3)
                .storeName("可乐").build();
        storeRepository.save(storePO1);

        for (int i = 0; i < 5; i++) {
            StorePO storePO = StorePO.builder().storeName("雪碧" + i).price(i + 2).picture("url" + i).storeUnit("瓶").build();
            storeRepository.save(storePO);
        }
        mockMvc.perform(get("/store"))
                .andExpect(status().isOk());
        assertEquals(6, storeRepository.findAll().size());
        assertEquals("可乐", storeRepository.findAll().get(0).getStoreName());

    }
}
