package com.emart.user.service;

import com.emart.user.entity.Buyer;
import com.emart.user.entity.Seller;
import com.emart.user.pojo.User;

public interface UserService {
	
	/**
	 * proceed to login for buyer or seller 
	 * @param User user
	 * @return JWT token
	 */
    String login(User user);

	/**
	 * buyer signUp
	 * @param Buyer buyer
	 */
    void buyerSignUp(Buyer buyer);
    
	/**
	 * seller signUp
	 * @param Seller seller
	 */
    void sellerSignUp(Seller seller);
    
	/**
	 * get buyer/seller user info
	 * @param String username
	 */
    User getUserInfo(String username);
    
//	/**
//	 * get buyerId by userName
//	 * @param String username
//	 */
//    Long getBuyerId(String username);
//    
//	/**
//	 * get sellerId by userName
//	 * @param String username
//	 */
//    Long getSellerId(String username);
}
