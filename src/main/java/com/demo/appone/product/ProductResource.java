package com.demo.appone.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductResource {

    private final List<Product> products;

    public ProductResource() {
        this.products = new ArrayList<>();
        this.products.add(new Product("1", "prodone", "Product One"));
        this.products.add(new Product("2", "prodtwo", "Product Two"));
        this.products.add(new Product("3", "prodthree", "Product Three"));
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return CollectionUtils.isEmpty(this.products) ? new ArrayList<>() : this.products;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable String id) {
        Optional<Product> product = this.products.stream().filter(prod -> prod.id().equals(id)).findFirst();

        if (product.isEmpty())
            return new ResponseEntity<>("""
                    {"status": "Product not found"}
                    """, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

}
