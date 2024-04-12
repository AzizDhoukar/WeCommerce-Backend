package org.example.wecommerce.repositories;

import org.example.wecommerce.models.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {

}
