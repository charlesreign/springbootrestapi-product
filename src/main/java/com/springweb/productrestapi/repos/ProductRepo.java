package com.springweb.productrestapi.repos;

import com.springweb.productrestapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
