package org.example.wecommerce.requests;

import lombok.Data;
import org.example.wecommerce.models.Product;

import java.util.List;

@Data
public class AddToCartRequest {
    private List<Product> products;
    private Integer quantity;

}
