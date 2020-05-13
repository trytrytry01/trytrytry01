package com.emart.user.service.impl;


import com.emart.user.dao.BuyerDao;
import com.emart.user.dao.RoleDao;
import com.emart.user.dao.SellerDao;
import com.emart.user.entity.Buyer;
import com.emart.user.entity.Role;
import com.emart.user.entity.Seller;
import com.emart.user.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BuyerDao buyerDao;
    @Autowired
    private SellerDao sellerDao;
    @Autowired
    private RoleDao roleDao;
    
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      	User user = null;

        //get user data from buyer table
        Buyer buyer = buyerDao.findByUsername(userName);
        if(buyer != null) {
        	user = new User();
        	user.setUsername(buyer.getUsername());
        	user.setPassword(buyer.getPassword());
        	List<Role> roles = roleDao.findByBuyerId(buyer.getId());
        	user.setAuthorities(roles);
        } else {
            //get user data from seller table
            Seller seller = sellerDao.findByUsername(userName);
            if(seller != null) {
            	user = new User();
            	user.setUsername(seller.getUsername());
            	user.setPassword(seller.getPassword());
            	List<Role> roles = roleDao.findBySellerId(seller.getId());
            	user.setAuthorities(roles);
            }
        }

        return user;
    }
}
