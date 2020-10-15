package com.service.serviceproduct.repository;

import java.util.List;

import com.service.serviceproduct.entity.Category;
import com.service.serviceproduct.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}
