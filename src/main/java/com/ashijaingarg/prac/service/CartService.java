package com.ashijaingarg.prac.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ashijaingarg.prac.dao.AppUserDAOImpl;
import com.ashijaingarg.prac.dao.CartDAOImpl;
import com.ashijaingarg.prac.dao.ProductDAOImpl;
import com.ashijaingarg.prac.model.AppUser;
import com.ashijaingarg.prac.model.Cart;
import com.ashijaingarg.prac.model.CartItem;
import com.ashijaingarg.prac.model.Product;
import com.ashijaingarg.prac.model.StatusType;

@Service
public class CartService {
	
private CartDAOImpl cartDaoImpl;
private ProductDAOImpl productDaoImpl;
private AppUserDAOImpl appUserDaoImpl;

public CartDAOImpl getCartDaoImpl() {
	return cartDaoImpl;
}

public void setCartDaoImpl(CartDAOImpl cartDaoImpl) {
	this.cartDaoImpl = cartDaoImpl;
}



public void setProductDaoImpl(ProductDAOImpl productDaoImpl) {
	this.productDaoImpl = productDaoImpl;
}

public void setAppUserDaoImpl(AppUserDAOImpl appUserDaoImpl) {
	this.appUserDaoImpl = appUserDaoImpl;
}

@Transactional
public void addCart(Cart cart) {
	this.cartDaoImpl.addCart(cart);
}

@Transactional
public Cart getCartById(int id) {
	return this.cartDaoImpl.getCartById(id);
}

@Transactional
public Product getProductById(int id) {
	return this.productDaoImpl.getProductById(id);
}

@Transactional
public Optional<Cart> getCartByUserId(int id) {
	return this.cartDaoImpl.getCartByUserId(id);
}

@Transactional
public AppUser getAppUserById(int id) {
	return this.appUserDaoImpl.getAppUserById(id);
}

@Transactional
public void addProductToUserCart(int userId, int productId, int quantity) {
	Product productById = productDaoImpl.getProductById(productId);
	CartItem cartItem = new CartItem();
	cartItem.setProduct(productById);
	cartItem.setQuantity(quantity);
	Optional<Cart> cartForUser = cartDaoImpl.getCartByUserId(userId);
	
	if(cartForUser.isPresent()) {
		cartForUser.get().addCartItem(cartItem);
		//Set<CartItem> cartItems = cartForUser.get().getCartItems();
		//cartItems.add(cartItem);
		cartForUser.get().setStatus(StatusType.Active);
		this.addCart(cartForUser.get());	
	}
	else {
		Cart cart = new Cart();
		//Set<CartItem> cartSet = new HashSet<>();
		//cartSet.add(cartItem);
		//cart.setCartItems(cartSet);
		cart.addCartItem(cartItem);
		cart.setStatus(StatusType.Active);
		AppUser user = appUserDaoImpl.getAppUserById(userId);
		cart.setUser(user);
		this.addCart(cart);	
	}
}


}
