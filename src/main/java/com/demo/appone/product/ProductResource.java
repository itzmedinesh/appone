package com.demo.appone.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id) {
        Optional<Product> product = productService.getProducts().stream().filter(prod -> prod.id() == id).findFirst();

        if (product.isEmpty())
            return new ResponseEntity<>("""
                    {"status": "Product not found"}
                    """, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

}
