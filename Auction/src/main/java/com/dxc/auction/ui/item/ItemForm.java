package com.dxc.auction.ui.item;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.dxc.auction.domain.user.User;

public class ItemForm {

	private Long id;

	@Size(min=3, max = 30, message = "size must be between 3 and 30")
	private String name;
	
	@Size(min=3, max=60, message = "size must be between 3 and 60")
	private String description;
	
	
	@Pattern(regexp = "^[0-9]{1,2}([.][0-9]{1,2})?$|100" , message = "minimum price: 0.1 maximum price: 100")
	private String buyNowPrice;

	private String owner;
	
	private User user;

	public ItemForm() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBuyNowPrice() {
		return buyNowPrice;
	}

	public void setBuyNowPrice(String buyNowPrice) {
		this.buyNowPrice = buyNowPrice;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}