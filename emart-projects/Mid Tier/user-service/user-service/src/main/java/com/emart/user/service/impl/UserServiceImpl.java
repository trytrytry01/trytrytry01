package com.emart.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.emart.user.dao.BuyerDao;
import com.emart.user.dao.SellerDao;
import com.emart.user.entity.Buyer;
import com.emart.user.entity.Seller;
import com.emart.user.entity.UserRole;
import com.emart.user.exception.validateException;
import com.emart.user.pojo.User;
import com.emart.user.service.UserService;
import com.emart.user.utils.JwtTokenUtil;
import com.emart.user.utils.Constants;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private BuyerDao buyerDao;
    
    @Autowired
    private SellerDao sellerDao;
    
    @Override
    public String login(User user) {
    	String username = user.getUsername();
    	String password = user.getPassword();

    	UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //get user details by name
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

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
	public Long getBuyerId(String username) {
		
		Buyer buyer = buyerDao.findByUsername(username);

		return buyer.getId();
	}

	@Override
	public Long getSellerId(String username) {
		Seller seller = sellerDao.findByUsername(username);
		
		return seller.getId();
	}



}
