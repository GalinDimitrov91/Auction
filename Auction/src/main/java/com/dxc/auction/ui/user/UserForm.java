package com.dxc.auction.ui.user;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.dxc.auction.domain.history.History;
import com.dxc.auction.domain.item.Item;
import com.dxc.auction.domain.role.Role;

/**
 * @author cscvntraining
 *
 */
public class UserForm {

	
	private Long id;

	@Size(min = 5, max = 10)
	private String username;

	@Size(min = 5, max = 10)
	private String password;

	private boolean isAccountNonExpired;

	private boolean isAccountNonLocked;

	private boolean isCredentialsNonExpired;

	private boolean isEnabled;

	@Range(min = 0, max = 1000000)
	private double balance;
	
	private List<Item> items;
	
	private List<History> history;
	
	private Set<Role> authorities;

	public Long getId() {
		return id;
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

	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Item> getAuctions() {
		return items;
	}

	public void setAuctions(List<Item> items) {
		this.items = items;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public Set<Role> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	
}
