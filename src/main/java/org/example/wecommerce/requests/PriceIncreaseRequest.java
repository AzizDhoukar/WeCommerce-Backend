package org.example.wecommerce.requests;

import lombok.Data;

@Data
public class PriceIncreaseRequest {

    private int productId;

    private int amount;
}