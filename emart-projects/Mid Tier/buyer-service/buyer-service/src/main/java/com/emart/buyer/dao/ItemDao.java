package com.emart.buyer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emart.buyer.entity.Item;

@Repository
public interface ItemDao extends JpaRepository<Item,Long> {
	
	@Query(value="SELECT A.*,D.username as seller_name,B.category_name,C.subcategory_name  FROM items A"
			+ "  INNER JOIN category B ON A.category_id = B.category_id "
			+ " INNER JOIN subcategory C ON A.subcategory_id = C.subcategory_id "
			+ " INNER JOIN seller D ON A.seller_id = D.id "
			+ " WHERE A.item_name Like :keyWords " 
			+ "      OR B.category_name LIKE " + ":keyWords " 
			+ "      OR C.subcategory_name LIKE " + ":keyWords"
			,
			nativeQuery = true)
    List<Item> searchItems(String keyWords);
	
	@Query(value="SELECT A.*,D.username as seller_name,B.category_name,C.subcategory_name FROM items A  "
			+ "INNER JOIN category B ON A.category_id = B.category_id "
			+ " INNER JOIN subcategory C ON A.subcategory_id = C.subcategory_id "
			+ " INNER JOIN seller D ON A.seller_id = D.id "
			+ " WHERE A.id = :itemId " 
			,
			nativeQuery = true)
	Item getOne(Long itemId);


}
