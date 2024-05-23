package com.demo.appone.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        jdbcTemplate.query("select * from product", rs -> {
            products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
        });
        return products;
    }

}
