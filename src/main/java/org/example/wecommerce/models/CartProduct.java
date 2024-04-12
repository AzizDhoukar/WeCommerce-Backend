package org.example.wecommerce.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    @OneToOne
    private Product cartProduct;

    private Integer cartItemQuantity;

    @ManyToOne
    private Cart cart;

    public CartProduct(Product cartProduct, Cart cart, Integer cartItemQuantity) {
        this.cartProduct = cartProduct;
        this.cartItemQuantity = cartItemQuantity;
        this.cart = cart;
    }
}