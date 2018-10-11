//package com.revature.controllers;
//
//
//import javax.servlet.http.HttpSession;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.revature.models.RUser;
//import com.revature.services.UserService;
//
//
//@Controller
//@CrossOrigin
//public class LoginController {
//
//	private static Logger log = Logger.getRootLogger();
//	private static UserService userService = new UserService();
//	
//	private LoginController() {
//		super();
//	}
//	
//	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
//	@ResponseBody
//	public RUser login(HttpSession session, @RequestParam("userName") String username, @RequestParam("pswd")String password) {
//	    RUser user = userService.authenticateUser(username, password);
//	    if(user!=null) {
//	        session.setAttribute("USER", user);
//	    } else {
//	        return null;
//	    }
//	    return user;
//	}
//
//}
