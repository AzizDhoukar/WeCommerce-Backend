package org.example.wecommerce.services;

import org.example.wecommerce.exeptions.NotFoundException;
import org.example.wecommerce.models.Product;
import org.example.wecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("product couldn't be found by following id: " + id));
    }

    
    public Product add(Product product) {
        this.productRepository.save(new Product(product.getProductName(),
                product.getProductDescription(), product.getProductPrice(),
                product.getStock(), product.getProductImageUrl()));
        return product;
    }

    
    public List<Product> getByproductName(String productName) {
        return this.productRepository.getByproductName(productName);
    }

    
    public void deleteById(int id) {
        this.productRepository.deleteById(id);
    }

    
    public void updateProductDetails(int productId, Product newProduct) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            Product existingProduct = product.get();
            existingProduct.setProductName(newProduct.getProductName());
            existingProduct.setProductDescription(newProduct.getProductDescription());
            existingProduct.setProductPrice(newProduct.getProductPrice());
            existingProduct.setStock(newProduct.getStock());
            existingProduct.setProductImageUrl(newProduct.getProductImageUrl());

            productRepository.save(product.get());
        }

    }

    

}
