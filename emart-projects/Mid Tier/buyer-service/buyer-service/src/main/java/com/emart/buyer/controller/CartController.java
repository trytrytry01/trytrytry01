package com.emart.buyer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.buyer.entity.CartItem;
import com.emart.buyer.pojo.Result;
import com.emart.buyer.service.CartService;

@RestController
@RequestMapping(value="/api/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;

    /**
     * buyer add items to cart
     */
    @PostMapping
    public Result addCartItem(@RequestBody CartItem cartItem) {

    	Result result = new Result();
    	
    	this.checkcartitemInfo(cartItem, result);
    	if(result.getMessages().size() > 0) {
    		result.setStatusCode(HttpStatus.BAD_REQUEST.value());
    		return result;
    	}
   
    	cartService.addcartItems(cartItem);

        result.setStatusCode(HttpStatus.OK.value());

        return result;
    }

    /**
     * checkout items
     */
    @Transactional
    @PutMapping(value="/checkout/{transactionId}")
    public Result checkoutItems(@PathVariable Long transactionId,
    		@RequestBody List<CartItem> CartItems) {

    	Result result = new Result();
    	
    	cartService.checkoutItems(CartItems, transactionId);
        result.setStatusCode(HttpStatus.OK.value());

        return result;
    }
    
    /**
     * view cart items
     */
    @GetMapping(value="/{buyerId}")
    public Result viewCartItems(@PathVariable Long buyerId) {

    	Result result = new Result();
    	
    	List<CartItem> cartItemList = cartService.viewCartItems(buyerId);
    	
    	result.setData(cartItemList);
        result.setStatusCode(HttpStatus.OK.value());

        return result;
    }

    /**
     * delete cart items
     */
    @DeleteMapping(value="/{id}")
    public Result deleteCartItem(@PathVariable Long id) {

    	Result result = new Result();

    	cartService.deleteCartItems(id);
        result.setStatusCode(HttpStatus.OK.value());

        return result;
    }
    
	private void checkcartitemInfo(CartItem cartItem, Result result) {
		ArrayList<String> messages = result.getMessages();
		if(cartItem.getItemId() == null) {
			messages.add("itemId is required!");
		}
		
		if(cartItem.getBuyerId() == null) {
			messages.add("buyerId is required!");
		}
		
		if(cartItem.getNumberOfItems() == null) {
			messages.add("numberOfItems is required!");
		}

	}

}
