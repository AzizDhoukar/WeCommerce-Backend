package org.example.wecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CartId;

    @OneToMany
    private List<CartProduct> cartProducts = new ArrayList<>();

    private Double cartTotal;

    @OneToOne
    private User user;

}