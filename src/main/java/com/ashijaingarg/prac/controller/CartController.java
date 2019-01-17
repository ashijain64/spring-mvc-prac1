package com.ashijaingarg.prac.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashijaingarg.prac.model.AppUser;
import com.ashijaingarg.prac.model.Cart;
import com.ashijaingarg.prac.model.CartItem;
import com.ashijaingarg.prac.model.Product;
import com.ashijaingarg.prac.model.StatusType;
import com.ashijaingarg.prac.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/add-to-cart/{id}",  method = RequestMethod.GET)
	public String addToCart( @PathVariable("id") int productId, ModelMap model) {
		int userId = 1;
		int quantity = 1;
		cartService.addProductToUserCart(userId, productId, quantity);
		model.put("userId", userId);
		return "add-to-cart";
		
	}
	
	@RequestMapping(value = "/display-user-cart/{id}", method = RequestMethod.GET)
	public String displayCart(ModelMap model, @PathVariable("id") String userId) {
		Optional<Cart> cartByUserId = cartService.getCartByUserId(Integer.parseInt(userId));
		model.put("cart", cartByUserId.get());
		return "display-user-cart";
	}
	
	

}
