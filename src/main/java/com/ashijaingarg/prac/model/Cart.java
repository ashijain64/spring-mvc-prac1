package com.ashijaingarg.prac.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private AppUser user;
	
	@Enumerated(EnumType.STRING)
	private StatusType status;
	
	//todo ashi to try different cascade types here.
	@OneToMany(mappedBy = "cart" , fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<CartItem> cartItems;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
		this.cartItems.forEach(c -> c.setCart(this));
	}
	
	public void addCartItem(CartItem cartItem) {
		if(this.getCartItems() == null) {
			this.cartItems = new HashSet<>();
		}
		this.getCartItems().add(cartItem);
		this.getCartItems().forEach(c -> c.setCart(this));
	}
	
}
