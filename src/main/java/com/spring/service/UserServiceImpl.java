package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.UserDAO;
import com.spring.model.User;


public class UserServiceImpl {

	@Autowired
	private UserDAO userdao;
	
	public void addUser(User user) {
		userdao.addUser(user);
		
	}
	public List<User> listusers(){
		return userdao.listusers();
	}
	 public boolean isUserExist(User user) {
	        return findByName(user.getLastname())!=null;
	    }
	 private static List<User> users;
	private User findByName(String lastname) {
		for(User user : users){
            if(user.getLastname().equalsIgnoreCase(lastname)){
                return user;
            }
        }
        return null;
	}

}
