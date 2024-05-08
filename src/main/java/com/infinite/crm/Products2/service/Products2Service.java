package com.infinite.crm.Products2.service;

import com.infinite.crm.Products2.model.Products2;
import com.infinite.crm.Products2.repository.Products2Repository;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Products2Service {

    @Autowired
    private Products2Repository repo;

    public Observable<Products2> adduser(Products2 newProduct) {
        return Observable.fromCallable(() -> repo.save(newProduct));
    }

    public Observable<Products2> productList() {
        return Observable.fromIterable(repo.findAll());
    }

    public Observable<Products2> productById(Long id) {
        return Observable.fromCallable(()->repo.findById(id).get());
    }

    /*public Products2 findById(Long id, Products2 newProduct) {
        return repo.findById(id).map(product->{
            product.setPname(newProduct.getPname());
            product.setRating(newProduct.getRating());
            product.setPrice(newProduct.getPrice());
            product.setBrand(newProduct.getBrand());
            return repo.save(product);
        }).get();
    }*/

    public Products2 findById(Long id, Products2 newProduct) {
        return repo.findById(id).map(product ->
                new Products2(
                        id, // Accessing the id field directly
                        newProduct.pname(),
                        newProduct.rating(),
                        newProduct.price(),
                        newProduct.brand()
                )
        ).map(repo::save).orElse(null);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }
}
