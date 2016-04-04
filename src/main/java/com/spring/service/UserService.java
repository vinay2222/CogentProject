package com.spring.service;

import java.util.List;

import com.spring.model.User;

public interface UserService {
	public void addUser(User user);
	public List<User> listusers();
	public boolean isUserExist(User user);
	
}
