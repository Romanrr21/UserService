package com.todo.user.service;

import com.todo.user.domain.User;

public interface UserService {

	public void add(User user);

	public boolean login(String username, String password);

}
