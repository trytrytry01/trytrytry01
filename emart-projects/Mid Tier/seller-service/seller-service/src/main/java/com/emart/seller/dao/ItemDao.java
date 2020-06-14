package com.emart.seller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emart.seller.entity.Item;

@Repository
public interface ItemDao extends JpaRepository<Item,Long> {

    List<Item> findBySellerId(Long sellerId);

}
