package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Supplier;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    Product findProductById(Integer id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    void deleteProductById(Integer id);
}
