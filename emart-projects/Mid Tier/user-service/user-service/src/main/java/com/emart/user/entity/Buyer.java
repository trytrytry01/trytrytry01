package com.emart.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description  
 * @Author  ljg
 * @Date 2020/05/05 
 */

@Entity
@Table ( name ="buyer")
public class Buyer  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * primary key ID
	 */
	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * buyer name
	 */
   	@Column(name = "username" )
	private String username;

	/**
	 * password
	 */
   	@Column(name = "password" )
	private String password;

	/**
	 * email id
	 */
   	@Column(name = "email" )
	private String email;
   	
	/**
	 * created time
	 */
   	@Column(name = "created_time" )
	private Date createdDateTime;
   	
	/**
	 * mobile
	 */
   	@Column(name = "mobile" )
	private String mobile;
   	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private List<UserRole> userRoles = new ArrayList<>();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "{" +
					"id='" + id + '\'' +
					"userName='" + username + '\'' +
					"password='" + password + '\'' +
					"email='" + email + '\'' +
					"mobile='" + mobile + '\'' +
					"createdDateTime='" + createdDateTime + '\'' +
				'}';
	}

}