package org.example.wecommerce.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productDescription;

    @Column(nullable = false)
    private double productPrice;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private String productImageUrl;

    public Product(String productName, String productDescription, double productPrice, int stock, String productImageUrl) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.stock = stock;
        this.productImageUrl = productImageUrl;
    }
}