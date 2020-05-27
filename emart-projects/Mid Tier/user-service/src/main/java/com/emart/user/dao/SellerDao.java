package com.emart.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emart.user.entity.Seller;

@Repository
public interface SellerDao extends JpaRepository<Seller,Integer> {
	
	Seller findByUsername(String username);

}
