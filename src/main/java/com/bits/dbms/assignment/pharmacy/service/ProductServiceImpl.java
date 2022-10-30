package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bits.dbms.assignment.pharmacy.repository.ProductRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Product saveProduct(Product product) {
        product.setCreated_on(new Date());
        product.setModified_on(new Date());
        product.setModified_by(product.getModified_by());
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
            return productRepository.save(product);
        }
        else {
            return saveProduct(updateProduct);
        }
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
