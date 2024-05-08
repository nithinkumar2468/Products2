package com.infinite.crm.Products2.controller;

import com.infinite.crm.Products2.model.Products2;
import com.infinite.crm.Products2.service.Products2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.reactivex.rxjava3.core.Observable;

@RestController
public class Products2Controller {

    @Autowired
    private Products2Service service;

    @PostMapping("/product2")
    public Observable<Products2> newProduct(@RequestBody Products2 newProduct) {
        return service.adduser(newProduct);
    }

    @GetMapping("/products2")
    Observable<Products2> getAllProducts() {
        return service.productList();
    }

    @GetMapping("/product2/{id}")
    public Observable<Products2> getProductById(@PathVariable Long id) {
        return service.productById(id);
    }

    @PutMapping("/product2/{id}")
    Products2 updateUser(@RequestBody Products2 newProduct, @PathVariable Long id) {
        return service.findById(id, newProduct);
    }

    @DeleteMapping("/product2/{id}")
    Observable<String> deleteProduct(@PathVariable Long id) {
        service.delete(id);
        return Observable.fromCallable(()->"Product with id " + id + " has been deleted successfully..!");
    }

}
