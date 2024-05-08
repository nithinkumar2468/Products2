package com.infinite.crm.Products2.repository;

import com.infinite.crm.Products2.model.Products2;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Products2Repository extends MongoRepository<Products2,Long> {
}
