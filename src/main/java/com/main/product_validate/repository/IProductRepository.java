package com.main.product_validate.repository;

import com.main.product_validate.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {

}
