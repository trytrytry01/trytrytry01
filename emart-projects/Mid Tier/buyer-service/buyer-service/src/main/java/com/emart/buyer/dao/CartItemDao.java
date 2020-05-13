package com.emart.buyer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emart.buyer.entity.CartItem;

@Repository
public interface CartItemDao extends JpaRepository<CartItem,Long> {
	
	@Query(value="SELECT A.id,A.buyer_id,A.item_id,B.item_name,A.number_of_items,A.created_time FROM cart A LEFT JOIN items B ON A.item_id=B.id WHERE A.buyer_id=:buyerId", nativeQuery = true)
    List<CartItem> findByBuyerId(Long buyerId);

}
