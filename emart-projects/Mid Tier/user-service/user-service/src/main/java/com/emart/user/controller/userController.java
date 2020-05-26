package com.emart.user.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.user.entity.Buyer;
import com.emart.user.entity.Seller;
import com.emart.user.exception.validateException;
import com.emart.user.pojo.Result;
import com.emart.user.pojo.User;
import com.emart.user.service.UserService;
import com.emart.user.utils.CheckUtil;

import antlr.collections.List;

@RestController
public class userController {

    @Autowired
    private UserService userService;
    
    /**
     * user login
     * return a Result with generated JWT when success
     */
    @PostMapping(value = "/login")
    public Result login(@RequestBody User user) {

    	Result result = new Result();
    	
    	String jwt = userService.login(user);
    	if(jwt == null) {
    		//user is not exist or the password is wrong
    		ArrayList<String> msgList = new ArrayList<String>();
    		msgList.add("user is not exist or the password is wrong");
    		result.setMessages(msgList);
    		result.setStatusCode(HttpStatus.BAD_REQUEST.value());
    	} else {
            // return a JWT when success
        	result.setData(jwt);        	
        	result.setStatusCode(HttpStatus.OK.value());
    	}
 	
        // return a Result with generated JWT data when success
        return result;
    }
    
    /**
     * buyer signUp
     */
    @PostMapping(value = "/buyer/signup")
    public Result buyerSignUp(@RequestBody Buyer buyer) {

    	Result result = new Result();
    	//check the buyer parameter
    	this.checkBuyerInfo(buyer, result);
    	if(result.getMessages().size() > 0) {
    		result.setStatusCode(HttpStatus.BAD_REQUEST.value());
    		return result;
    	}

    	//check the duplicate of username
    	User user = userService.getUserInfo(buyer.getUsername());
    	if(user != null) {
    		result.getMessages().add("the username has been used!");
    	}
    	if(result.getMessages().size() > 0) {
    		result.setStatusCode(HttpStatus.BAD_REQUEST.value());
    		return result;
    	}
    	
    	//create buyer to DB
        userService.buyerSignUp(buyer);

        result.setStatusCode(HttpStatus.OK.value());
        return result;
    }

    /**
     * seller signUp
     */
    @PostMapping(value = "/seller/signup")
    public Result sellerSignUp(@RequestBody Seller seller) {
    	
    	Result result = new Result();
    	//check the seller parameter
    	this.checkSellerInfo(seller, result);
    	if(result.getMessages().size() > 0) {
    		result.setStatusCode(HttpStatus.BAD_REQUEST.value());
    		return result;
    	}
    	
    	//check the duplicate of username
    	User user = userService.getUserInfo(seller.getUsername());
    	if(user != null) {
    		result.getMessages().add("the username has been used!");
    	}
    	if(result.getMessages().size() > 0) {
    		result.setStatusCode(HttpStatus.BAD_REQUEST.value());
    		return result;
    	}
    	
    	//create buyer to DB
    	userService.sellerSignUp(seller);;

        result.setStatusCode(HttpStatus.OK.value());
        return result;
        
    }
    
    /**
     * get user info by username
     */
    @GetMapping(value = "/user")
    public User getUserInfo(String username) {
        // return user info
        return userService.getUserInfo(username);
    }
    
//    /**
//     * get buyer user id by username
//     */
//    @GetMapping(value = "/buyer")
//    public Long getBuyerId(String username) {
//        // return a JWT when success
//        return userService.getBuyerId(username);
//    }
//    
//    /**
//     * get seller user id by username
//     */
//    @GetMapping(value = "/seller")
//    public Long getSellerId(String username) {
//        // return a JWT when success
//        return userService.getSellerId(username);
//    }
    

	private void checkBuyerInfo(Buyer buyer, Result result) {
		ArrayList<String> messages = result.getMessages();
		if(buyer.getUsername() == null || buyer.getUsername().length() == 0) {
			messages.add("username is required!");
		}
		if(buyer.getPassword() == null || buyer.getPassword().length() < 0) {
			messages.add("password length must be greater than 6!");
		}
		if(buyer.getEmail() == null || buyer.getEmail().length() == 0) {
			messages.add("eamil is required!");
		} else if(!buyer.getEmail().contains("@")) {
			messages.add("eamil is invalid!");
		}
		
		if(buyer.getMobile() == null || buyer.getMobile().length() < 11
				|| buyer.getMobile().length() > 16) {
			messages.add("mobile length must be greater than 11 and less than 16!");
		} else if(!CheckUtil.isNumeric(buyer.getMobile())) {
			messages.add("please input only numberic for mobile!");
		}
	}
	
	private void checkSellerInfo(Seller seller, Result result) {
		ArrayList<String> messages = result.getMessages();
		if(seller.getUsername() == null || seller.getUsername().length() == 0) {
			messages.add("username is required!");
		}
		
		if(seller.getPassword() == null || seller.getPassword().length() < 0) {
			messages.add("password length must be greater than 6!");
		}
		
		if(seller.getEmail() == null || seller.getEmail().length() == 0) {
			messages.add("eamil is required!");
		} else if(!seller.getEmail().contains("@")) {
			messages.add("eamil is invalid!");
		}
		
		if(seller.getContactNo() == null || seller.getContactNo().length() == 0) {
			messages.add("contactNo is required!");
		}
		
		if(seller.getCompanyName() == null || seller.getCompanyName().length() == 0) {
			messages.add("companyName is required!");
		}	
		
		if(seller.getWebsite() == null || seller.getWebsite().length() == 0) {
			messages.add("website is required!");
		}
		
		if(seller.getGstin() == null || seller.getGstin().length() == 0) {
			messages.add("gstin is required!");
		}

	}
}
