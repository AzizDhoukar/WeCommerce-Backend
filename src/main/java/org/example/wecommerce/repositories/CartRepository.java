package org.example.wecommerce.repositories;

import org.example.wecommerce.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
