package com.emart.buyer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.buyer.dao.CartItemDao;
import com.emart.buyer.dao.PurchaseHistoryDao;
import com.emart.buyer.entity.CartItem;
import com.emart.buyer.entity.PurchaseHistory;
import com.emart.buyer.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartItemDao cartItemDao;
	
	@Autowired
	private PurchaseHistoryDao purchaseHistoryDao;
    
	@Override
	public void addcartItems(CartItem cartItem) {
		cartItem.setCreatedDateTime(new Date());
		cartItemDao.save(cartItem);
	}

	@Override
	public void updateCartItems(List<CartItem> cartItemList) {
		cartItemDao.saveAll(cartItemList);		
	}

	@Override
	public List<CartItem> viewCartItems(Long buyerId) {
		return cartItemDao.findByBuyerId(buyerId);
	}

	@Override
	public void deleteCartItems(Long id) {
		cartItemDao.deleteById(id);;
	}

	@Override
	public void checkoutItems(List<CartItem> cartItemList, Long transactionId) {
		// delete cart item list
		cartItemDao.deleteAll(cartItemList);
		
		//save Purchase History
    	List<PurchaseHistory> purchaseHistoryList = new ArrayList<PurchaseHistory>();
    	for(CartItem cartItem : cartItemList) {
    		PurchaseHistory purchaseHistory = new PurchaseHistory();
    		purchaseHistory.setBuyerId(cartItem.getBuyerId());
    		purchaseHistory.setItemId(cartItem.getItemId());
    		purchaseHistory.setNumberOfItems(cartItem.getNumberOfItems());
    		purchaseHistory.setTransactionId(transactionId);
    		purchaseHistory.setPurchaseDatetime(new Date());
    		purchaseHistoryList.add(purchaseHistory);
    	}
		purchaseHistoryDao.saveAll(purchaseHistoryList);
	}
}
