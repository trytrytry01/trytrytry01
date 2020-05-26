package com.emart.seller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emart.seller.entity.Item;

@Repository
public interface ItemDao extends JpaRepository<Item,Long> {
	@Query(value="SELECT A.*,B.category_name as categoryName,C.subcategory_name FROM items A "
			+ "LEFT JOIN category B ON A.category_id=B.category_id "
			+ "LEFT JOIN subcategory C ON A.subcategory_id=C.subcategory_id "
			+ "WHERE A.seller_id=:sellerId", nativeQuery = true)
    List<Item> findBySellerId(Long sellerId);

}
