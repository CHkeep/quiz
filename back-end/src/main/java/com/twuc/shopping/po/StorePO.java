package com.twuc.shopping.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorePO {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String storeName;
    private  double  price;
    private String storeUnit;
    private String picture;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "storePO")
    private List<OrderPO> orderPOS;
}
