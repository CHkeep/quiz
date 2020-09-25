package com.twuc.shopping.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "store")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorePO {
    @Id
    @GeneratedValue
    private int id;
    private String storeName;
    private  double  price;
    private String storeUnit;
    private String picture;
//    private  int payNum = 0;
//    @ManyToOne
//    private OrderPO OrderPO;

}
