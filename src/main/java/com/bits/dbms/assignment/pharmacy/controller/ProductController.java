package com.bits.dbms.assignment.pharmacy.controller;
import com.bits.dbms.assignment.pharmacy.entity.Product;
import com.bits.dbms.assignment.pharmacy.entity.Supplier;
import com.bits.dbms.assignment.pharmacy.service.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable(value = "id") Long id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public Product saveProduct(@Validated @RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping
    public Product updateProduct(@Validated @RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public String deleteSupplierById(@PathVariable(value = "id") Long id) {
        productService.deleteProductById(id);
        return "Deleted Successfully";
    }
}
