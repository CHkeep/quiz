package com.twuc.shopping.api;

import com.twuc.shopping.domain.Store;
import com.twuc.shopping.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    final StoreService storeService;
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/st/store")
    public ResponseEntity addStore(@RequestBody Store store) {
        return storeService.addstore(store);
    }


    @GetMapping("/st/store")
    public ResponseEntity getStore() {
        return storeService.gettore();
    }


}