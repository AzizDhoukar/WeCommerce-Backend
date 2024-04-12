package org.example.wecommerce.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wecommerce.models.Product;
import org.example.wecommerce.services.CartService;
import org.example.wecommerce.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    private final UpdateProductPriceService updateProductPriceService;

    @PostMapping("add")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        this.productService.add(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        final List<Product> products = productService.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("getByProductName/{productName}")
    public ResponseEntity<List<Product>> getByproductName(@PathVariable String productName) {
        List<Product> products = this.productService.getByproductName(productName);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteByid(@PathVariable int id) {
        this.productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("addToCart/{id}")
    public ResponseEntity<?> addToCart(@RequestBody List<Product> products, @PathVariable int id) {
        CartService.addToCart(int productId, int cartId, Integer quantity);
        return ResponseEntity.ok(ECommerceMessage.ADD_TO_CART);
    }

    @GetMapping("getCart")
    public ResponseEntity<?> getCart() {
        return ResponseEntity.ok(productService.getCart());
    }

    @DeleteMapping("removeFromCart/{id}")
    public ResponseEntity<?> removeFromCart(@PathVariable int id) {
        productService.removeFromCart(id);
        return ResponseEntity.ok(ECommerceMessage.REMOVE_FROM_CART);
    }

    @GetMapping("searchByProduct/{productName}")
    public ResponseEntity<?> searchByProduct(@PathVariable String productName) {
        Map<Integer, Object> result = productService.searchByProduct(productName);
        return ResponseEntity.ok(result);
    }

    @PostMapping("confirmCart")
    public ResponseEntity<?> confirmCart(@RequestBody ConfirmCartRequest confirmCartRequest) {
        productService.confirmCart(confirmCartRequest);
        return ResponseEntity.ok(ECommerceMessage.ITEMS_IN_THE_CART_HAVE_BEEN_PURCHASED);
    }

    @GetMapping("getAllConfirmedCart")
    public ResponseEntity<?> getAllConfirmedOrder() {
        return ResponseEntity.ok(productService.getAllConfirmedOrder());
    }

    @GetMapping("getConfirmedOrderById/{id}")
    public ResponseEntity<?> getConfirmedOrderById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getConfirmedOrderById(id));
    }

    @GetMapping("getConfirmedOrderByOrderNumber/{orderNumber}")
    public ResponseEntity<?> getConfirmedOrderByOrderNumber(@PathVariable Long orderNumber) {
        return ResponseEntity.ok(productService.getConfirmedOrderByOrderNumber(orderNumber));
    }

    @PutMapping("createCampaign")
    public ResponseEntity<?> createCampaign(@RequestBody CampaignCreateRequest campaignCreateRequest) {
        updateProductPriceService.createCampaign(campaignCreateRequest);
        return ResponseEntity.ok("success");
    }

    @PutMapping("priceIncrease")
    public ResponseEntity<?> priceIncrease(@RequestBody PriceIncreaseRequest priceIncreaseRequest) {
        updateProductPriceService.priceIncrease(priceIncreaseRequest);
        return ResponseEntity.ok("success");
    }

    @PutMapping("update-product-details")
    public ResponseEntity<?> updateByProductDetails(@RequestBody ProductDetailsUpdateRequest updateRequest) {
        productService.updateByProductDetails(updateRequest.getProductId(), updateRequest.getProductDetails());
        return ResponseEntity.ok("success");
    }

    @PutMapping("addFavorite/{productId}")
    public ResponseEntity<?> addFavorite(@PathVariable("productId") int productId) {
        productService.addFavorite(productId);
        return ResponseEntity.ok(ECommerceMessage.ADDED_TO_FAVORITES);
    }

    @GetMapping("getNumberOfFavorite/{productId}")
    public ResponseEntity<?> getNumberOfFavorite(@PathVariable("productId") int productId) {
        return ResponseEntity.ok(productService.getNumberOfFavorite(productId));
    }

    @PutMapping("removeFromFavorite/{productId}")
    public ResponseEntity<?> removeFromFavorite(@PathVariable("productId") int productId) {
        productService.removeFromFavorites(productId);
        return ResponseEntity.ok(ECommerceMessage.REMOVE_FROM_FAVORITES);
    }
}
