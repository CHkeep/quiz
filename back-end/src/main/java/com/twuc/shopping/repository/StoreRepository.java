package com.twuc.shopping.repository;

import com.twuc.shopping.po.StorePO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreRepository extends CrudRepository<StorePO, Integer> {
    @Override
    List<StorePO> findAll();
}
