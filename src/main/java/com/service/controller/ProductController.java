package com.service.controller;

import java.util.ArrayList;
import java.util.List;

import com.service.serviceproduct.entity.Category;
import com.service.serviceproduct.entity.Product;
import com.service.serviceproduct.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> allProducts(
            @RequestParam(name = "categoryId", required = false) Long category) {

        List<Product> products = new ArrayList<>();

        if (category == null) {
            products = productService.listAllProduct();
            if (products.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

        } else {
            products = productService.findByCategory(Category.builder().id(category).build());
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }

        return ResponseEntity.ok(products);

    }

}
