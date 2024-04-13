package org.example.wecommerce.services;

import org.example.wecommerce.exeptions.NotFoundException;
import org.example.wecommerce.models.Product;
import org.example.wecommerce.repositories.ProductRepository;
import org.example.wecommerce.requests.PriceIncreaseRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void priceIncrease(PriceIncreaseRequest priceIncreaseRequest) {
        Optional<Product> product = productRepository.findById(priceIncreaseRequest.getProductId());

        if (product.isPresent()) {
            product.get().setPrice(product.get().getPrice() + priceIncreaseRequest.getAmount());
            productRepository.save(product.get());
        }
    }


    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("product couldn't be found by following id: " + id));
    }


    public Product add(Product product) {
        this.productRepository.save(new Product(product.getName(),
                product.getDescription(), product.getPrice(),
                product.getImageUrl(), product.getRating()
        ));
        return product;
    }

    
    public List<Product> getByproductName(String productName) {
        return this.productRepository.getByName(productName);
    }

    
    public void deleteById(int id) {
        this.productRepository.deleteById(id);
    }

    
    public void updateProduct(int productId, Product product) {
        productRepository.save(product);
    }

    

}
