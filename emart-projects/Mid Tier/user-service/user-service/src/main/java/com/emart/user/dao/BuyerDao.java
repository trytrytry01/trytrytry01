package com.emart.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emart.user.entity.Buyer;

@Repository
public interface BuyerDao extends JpaRepository<Buyer,Integer>{

	Buyer findByUsername(String username);

}
