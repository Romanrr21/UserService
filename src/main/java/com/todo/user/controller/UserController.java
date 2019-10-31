package com.todo.user.controller;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.user.domain.User;
import com.todo.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	private final static Log logger = LogFactory.getLog(UserController.class);

	@Autowired
	UserServiceImpl userService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@RequestBody User user) {
		logger.info("Addding new User");
		userService.add(user);
		logger.info("User is added");
		return ResponseEntity.status(HttpStatus.OK).body("User is added");
	}

	@RequestMapping(method = RequestMethod.GET, path = ("/login"))
	public ResponseEntity<User> login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		logger.info("user =" + username +", password = "+" password"+ " is trying to login");
		User user  = userService.login(username, password);
		if(user != null)
			return ResponseEntity.status(HttpStatus.OK).body(user);
		else
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
		
	}

}
