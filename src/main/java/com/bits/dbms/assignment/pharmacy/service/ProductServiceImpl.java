package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Product;
import com.bits.dbms.assignment.pharmacy.entity.Supplier;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Product updateProduct(Product updateProduct) {
        Product product = findProductById(updateProduct.getProduct_id());
        if(product != null) {
            product.setCategory_id(updateProduct.getCategory_id());
            product.setExpiry_duration(updateProduct.getExpiry_duration());
            product.setIs_discountable(updateProduct.getIs_discountable());
            product.setProduct_name(updateProduct.getProduct_name());
            product.setThreshold_qty(updateProduct.getThreshold_qty());
            product.setModified_on(new Date());
            return productRepository.merge(product);
        }
        else {
            return saveProduct(updateProduct);
        }
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }
}
