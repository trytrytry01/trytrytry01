package com.emart.user.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name ="user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

	/**
	 * buyer id
	 */
   	@Column(name = "buyer_id" )
	private Long buyerId;

	/**
	 * seller id
	 */
   	@Column(name = "seller_id" )
	private Long sellerId;
   	
	/**
	 * role id
	 */
   	@Column(name = "role_id" )
	private Long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "{" +
					"id='" + id + '\'' +
					"buyerId='" + buyerId + '\'' +
					"sellerId='" + sellerId + '\'' +
					"roleId='" + roleId + '\'' +
				'}';
	}
}
