package org.example.wecommerce.services;

import org.example.wecommerce.exeptions.NotFoundException;
import org.example.wecommerce.models.Cart;
import org.example.wecommerce.models.CartProduct;
import org.example.wecommerce.models.Product;
import org.example.wecommerce.repositories.CartProductRepository;
import org.example.wecommerce.repositories.CartRepository;
import org.example.wecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {


    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartProductRepository cartProductRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartProductRepository cartProductRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartProductRepository = cartProductRepository;
    }

    
    public Cart getById(int id) {
        Optional<Cart> cart = cartRepository.findById(id);

        return cart.orElseThrow(() -> new NotFoundException("cart couldn't be found by following id: " + id));
    }

    
    public void deleteById(int id) {
        cartRepository.deleteById(id);
    }

    
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    
    public void add(Cart cart) {
        cartRepository.save(cart);
    }

    public CartProduct addToCart(int productId, int cartId, Integer quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("product couldn't be found by following id: " + productId));
        Cart cart = getById(cartId);

        CartProduct newCartProduct = new CartProduct(product, cart, quantity);
        cartProductRepository.save(newCartProduct);

        cart.setCartTotal(cart.getCartTotal() + quantity);

        return newCartProduct;
    }


}
