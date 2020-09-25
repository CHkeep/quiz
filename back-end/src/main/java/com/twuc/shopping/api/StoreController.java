package com.twuc.shopping.api;

import com.twuc.shopping.domain.Store;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StoreController {

    @PostMapping("/st/store")
    public ResponseEntity addStore(@RequestBody Store store) {
        return null;
    }

}