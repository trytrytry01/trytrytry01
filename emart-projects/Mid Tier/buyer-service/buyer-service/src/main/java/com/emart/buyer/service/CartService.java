package com.emart.buyer.service;

import java.util.List;

import com.emart.buyer.entity.CartItem;
import com.emart.buyer.entity.PurchaseHistory;

public interface CartService {

	/**
	 * add cartItem
	 * @param CartItem cartItem
	 */
    void addcartItems(CartItem cartItem);
    
	/**
	 * view cart items
	 * @param Long buyerId
	 */
    List<CartItem> viewCartItems(Long buyerId);
    
	/**
	 * delete cart items
	 * @param Long id
	 */
    void deleteCartItems(Long id);
    
	/**
	 * checkout cartItems
	 * @param List<CartItem> cartItemList
	 * @param Long buyerId
	 * @param Long transactionId
	 */
    void checkoutItems(List<CartItem> cartItemList, Long transactionId);
}
