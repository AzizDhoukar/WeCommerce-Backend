package org.example.wecommerce.repositories;

import org.example.wecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getByName(String name);
}
