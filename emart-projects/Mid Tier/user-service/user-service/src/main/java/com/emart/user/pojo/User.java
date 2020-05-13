package com.emart.user.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.emart.user.entity.Role;

public class User implements UserDetails , Serializable {

	/**
	 * user name
	 */
	private String username;

	/**
	 * password
	 */
	private String password;
	
	/**
	 * userType (0:buyer 1:seller)
	 */
	private String userType = "0";
	
	/**
	 * role list
	 */
    private List<Role> authorities;

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
    @Override
    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }
	
    /**
     * if account expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * if locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * if password expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * if user is enabled
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
	
}
