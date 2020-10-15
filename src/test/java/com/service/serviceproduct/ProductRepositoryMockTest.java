package com.service.serviceproduct;

import java.util.Date;
import java.util.List;

import com.service.serviceproduct.entity.Category;
import com.service.serviceproduct.entity.Product;
import com.service.serviceproduct.repository.ProductRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct() {
        Product product01 = Product.builder().name("computer").category(Category.builder().id(1L).build())
                .description("").stock(Double.parseDouble("10")).price(Double.parseDouble("1240.99")).status("Created")
                .createdAt(new Date()).build();
        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(founds.size()).isEqualTo(3);

    }
}