package com.twuc.shopping.repository;

import com.twuc.shopping.po.StorePO;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<StorePO, Integer> {
}
