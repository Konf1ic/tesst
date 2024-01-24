package com.main.product_validate.repository;

import com.main.product_validate.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Products, Long> {

    List<Products> findAllByNameContaining(String name);
}
