package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Supplier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Product saveProduct(Product product) {
        product.setCreated_on(new Date());
        product.setModified_on(null);
        product.setModified_by(null);
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return null;
    }

    public void deleteProductById(Integer id) {

    }
}
