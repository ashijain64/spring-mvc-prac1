package com.ashijaingarg.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String showUser(ModelMap model) {
		User user = new User();
		user.setName("Foo");
		userService.addUser(user);
		model.put("user", user);
		return "Hello";
	}

}
