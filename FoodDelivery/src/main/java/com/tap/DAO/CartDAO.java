package com.tap.DAO;

import java.util.List;
import com.tap.model.Cart;

public interface CartDAO {

    void addCartItem(Cart cart);

    void updateCartItem(Cart cart);

    void deleteCartItem(int cartId);

    Cart getCartItem(int cartId);

    List<Cart> getAllCartItems();
    
    void updateQuantity(int cartId, int quantity);
}
