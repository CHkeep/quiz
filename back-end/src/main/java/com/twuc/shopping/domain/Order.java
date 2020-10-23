package com.twuc.shopping.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private double price;
    private int storeId;
}