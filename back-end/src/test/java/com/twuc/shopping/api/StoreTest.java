package com.twuc.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Store;
import com.twuc.shopping.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StoreTest {

        @Autowired
        MockMvc mockMvc;
        @Autowired
        StoreRepository storeRepository;

        ObjectMapper objectMapper = new ObjectMapper();
        Store store;

        @Test
        public void should_add_store () throws Exception {
            Store store = new Store("可乐",1,"瓶","url");
            String jsonString = objectMapper.writeValueAsString(store);
            mockMvc.perform(post("/st/store").content(jsonString)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
            assertEquals(1, storeRepository.findAll().size());
        }

}
