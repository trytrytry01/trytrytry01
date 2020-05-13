package com.emart.buyer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emart.buyer.entity.PurchaseHistory;

@Repository
public interface PurchaseHistoryDao extends JpaRepository<PurchaseHistory,Integer> {

}
