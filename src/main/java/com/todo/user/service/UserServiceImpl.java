package com.todo.user.service;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.todo.user.controller.UserController;
import com.todo.user.domain.User;
import com.todo.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private final static Log logger = LogFactory.getLog(UserServiceImpl.class);
	@Autowired
	UserRepository userRepository;

	@Override
	public void add(User user) {
		logger.info("Adding user in service");
		userRepository.save(user);
		logger.info("Added user in service");

	}

	@Override
	public boolean login(String username, String password) {
		logger.info("user logging in service");
		User user = new User();
		user.setId(1L);
		user.setUsername(username);
//		user.setPassword(password);
		Example<User> userExample=Example.of(user);
		Optional<User> useroptional = userRepository.findOne(userExample);
		
		if (useroptional.get() != null)
			return true;
		else
			return false;
	}

}
