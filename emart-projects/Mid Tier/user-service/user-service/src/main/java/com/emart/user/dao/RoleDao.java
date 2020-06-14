package com.emart.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emart.user.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role,Integer> {
	
	@Query(value="SELECT A.id,A.name FROM role A LEFT JOIN user_role B ON A.id=B.role_id WHERE B.seller_id=:sellerId", nativeQuery = true)
	List<Role> findBySellerId(Long sellerId);
	
	@Query(value="SELECT A.id,A.name FROM role A LEFT JOIN user_role B ON A.id=B.role_id WHERE B.buyer_id=:buyerId", nativeQuery = true)
	List<Role> findByBuyerId(Long buyerId);

}
