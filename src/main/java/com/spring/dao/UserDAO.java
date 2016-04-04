package com.spring.dao;

import java.util.List;

import com.spring.model.User;

public interface UserDAO {
	public void addUser(User user);
	public List<User> listusers();

}
