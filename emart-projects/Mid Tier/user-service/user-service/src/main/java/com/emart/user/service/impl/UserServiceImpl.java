package com.emart.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.emart.user.dao.BuyerDao;
import com.emart.user.dao.RoleDao;
import com.emart.user.dao.SellerDao;
import com.emart.user.entity.Buyer;
import com.emart.user.entity.Role;
import com.emart.user.entity.Seller;
import com.emart.user.entity.UserRole;
import com.emart.user.pojo.User;
import com.emart.user.service.UserService;
import com.emart.user.utils.JwtTokenUtil;
import com.emart.user.utils.Constants;

@Service
public class UserServiceImpl implements UserService {

   
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private BuyerDao buyerDao;
    @Autowired
    private SellerDao sellerDao;
    @Autowired
    private RoleDao roleDao;
    
    @Override
    public String login(User user) {
    	String username = user.getUsername();
    	String password = user.getPassword();
    	String encode_pass = DigestUtils.md5DigestAsHex(password.getBytes());

        //get user details by name
        User userDetails = getUserInfo(username);

        if(userDetails == null 
        		|| !userDetails.getUserType().equals(user.getUserType())
        		|| !encode_pass.equals(userDetails.getPassword())) {
        	// user is not exist or the password is wrong
        	return null;
        }
        //generate JWT 
        String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

	@Override
	public void buyerSignUp(Buyer buyer) {
		//set the buyer role
		List<UserRole> roles = new ArrayList<>();
		UserRole userRole = new UserRole();
		userRole.setBuyerId(buyer.getId());
		userRole.setRoleId(Long.valueOf(Constants.ROLE_BUYER));
		roles.add(userRole);
		buyer.setUserRoles(roles);

		//encode the password
		String encodePassword = DigestUtils.md5DigestAsHex(buyer.getPassword().toString().getBytes());
		buyer.setPassword(encodePassword);
		//set the created date time
		buyer.setCreatedDateTime(new Date());
		
		//create the buyer and user-role to DB
		buyerDao.save(buyer);
		
	}

	@Override
	public void sellerSignUp(Seller seller) {
		//set the seller role
		List<UserRole> roles = new ArrayList<>();
		UserRole userRole = new UserRole();
		userRole.setBuyerId(seller.getId());
		userRole.setRoleId(Long.valueOf(Constants.ROLE_SELLER));
		roles.add(userRole);
		seller.setUserRoles(roles);

		//encode the password
		String encodePassword = DigestUtils.md5DigestAsHex(seller.getPassword().toString().getBytes());
		seller.setPassword(encodePassword);
		//set the created date time
		seller.setCreatedDateTime(new Date());
		
		//create the seller and user-role to DB
		sellerDao.save(seller);		
	}

	@Override
	public User getUserInfo(String username) {
		User user = null;

        //get user data from buyer table
        Buyer buyer = buyerDao.findByUsername(username);
        if(buyer != null) {
        	user = new User();
        	user.setUserId(buyer.getId());
        	user.setUserType("0");   //0:buyer
        	user.setUsername(buyer.getUsername());
        	user.setPassword(buyer.getPassword());
        	List<Role> roles = roleDao.findByBuyerId(buyer.getId());
        	user.setAuthorities(roles);
        } else {
            //get user data from seller table
            Seller seller = sellerDao.findByUsername(username);
            if(seller != null) {
            	user = new User();
            	user.setUserId(seller.getId());
            	user.setUserType("1");   //1:seller
            	user.setUsername(seller.getUsername());
            	user.setPassword(seller.getPassword());
            	List<Role> roles = roleDao.findBySellerId(seller.getId());
            	user.setAuthorities(roles);
            }
        }

        return user;
	}

//	@Override
//	public Long getBuyerId(String username) {
//		
//		Buyer buyer = buyerDao.findByUsername(username);
//
//		return buyer.getId();
//	}
//
//	@Override
//	public Long getSellerId(String username) {
//		Seller seller = sellerDao.findByUsername(username);
//		
//		return seller.getId();
//	}


}
