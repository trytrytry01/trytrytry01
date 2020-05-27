package com.emart.user.pojo;

import java.io.Serializable;
import java.util.List;

import com.emart.user.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * user id
	 */
	private Long userId;
	
	/**
	 * user type(0:buyer  1:seller default=0)
	 */
	private String userType = "0";

	/**
	 * user name
	 */
	private String username;

	/**
	 * password
	 */
	private String password;
	

	/**
	 * role list
	 */
    private List<Role> authorities;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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
	
    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }
	
    /**
     * if account expired
     */
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * if locked
     */
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * if password expired
     */
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * if user is enabled
     */
    public boolean isEnabled() {
        return true;
    }
	
}
