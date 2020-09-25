package com.twuc.shopping.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private String storeName;
    private  double  price;
    private String storeUnit;
    private String picture;

//    private int orderId;
//
//    private  int payNum;

}
