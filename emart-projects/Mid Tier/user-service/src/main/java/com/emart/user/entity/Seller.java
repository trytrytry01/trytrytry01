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
@Table ( name ="seller")
public class Seller  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * primary key id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
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
	 * company name
	 */
   	@Column(name = "company_name" )
	private String companyName;
   	
	/**
	 * GSTIN
	 */
   	@Column(name = "GSTIN" )
	private String gstin;

	/**
	 * brief about company
	 */
   	@Column(name = "brief" )
	private String brief;
   	
	/**
	 * postal address
	 */
   	@Column(name = "postal_address" )
	private String postalAddress;
   	
	/**
	 * website url
	 */
   	@Column(name = "website" )
	private String website;
   	
	/**
	 * email id
	 */
   	@Column(name = "email" )
	private String email;
   	
	/**
	 * contact No
	 */
   	@Column(name = "contactno" )
	private String contactNo;
   	
	/**
	 * created time
	 */
   	@Column(name = "created_time" )
	private Date createdDateTime;
   	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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
					"username='" + username + '\'' +
					"password='" + password + '\'' +
					"companyName='" + companyName + '\'' +
					"gstin='" + gstin + '\'' +
					"brief='" + brief + '\'' +
					"postalAddress='" + postalAddress + '\'' +
					"website='" + website + '\'' +
					"email='" + email + '\'' +
					"contactNo='" + contactNo + '\'' +					
					"createdtime='" + createdDateTime + '\'' +
				'}';
	}

}