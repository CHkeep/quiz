package com.twuc.shopping.service;

import com.twuc.shopping.domain.Store;
import com.twuc.shopping.po.StorePO;
import com.twuc.shopping.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    StoreRepository storeRepository;
    public ResponseEntity addstore(Store store) {
        StorePO storePO = StorePO.builder()
                .storeName(store.getStoreName())
                .storeUnit(store.getStoreUnit())
                .picture(store.getPicture())
                .price(store.getPrice())
                .build();
        storeRepository.save(storePO );
        return  ResponseEntity.ok().build();
    }
}
