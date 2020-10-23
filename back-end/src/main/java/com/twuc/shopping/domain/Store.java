package com.twuc.shopping.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @NotNull
    private String storeName;
    @NotNull
    private  double  price;
    @NotNull
    private String storeUnit;
    @NotNull
    private String picture;

}
