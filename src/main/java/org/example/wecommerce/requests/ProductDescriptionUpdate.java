package org.example.wecommerce.requests;

import lombok.Data;
import org.example.wecommerce.models.Product;

@Data
public class ProductDescriptionUpdate {

    private int productId;

    private Product product;
}
