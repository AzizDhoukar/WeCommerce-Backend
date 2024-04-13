package org.example.wecommerce.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wecommerce.models.Product;
import org.example.wecommerce.requests.PriceIncreaseRequest;
import org.example.wecommerce.requests.ProductDescriptionUpdate;
import org.example.wecommerce.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("add")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        Product newProduct =  this.productService.add(product);
        return ResponseEntity.ok(newProduct);
    }

    @PostMapping("addList")
    public ResponseEntity<List<Product>> addList(@RequestBody List<Product> products) {
        for(Product product : products){
            add(product);
        }
        return ResponseEntity.ok(products);
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
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        this.productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("priceIncrease")
    public ResponseEntity<?> priceIncrease(@RequestBody PriceIncreaseRequest priceIncreaseRequest) {
        productService.priceIncrease(priceIncreaseRequest);
        return ResponseEntity.ok("success");
    }

    @PutMapping("updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDescriptionUpdate updateRequest) {
        productService.updateProduct(updateRequest.getProductId(), updateRequest.getProduct());
        return ResponseEntity.ok("success");
    }
}
