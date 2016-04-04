package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.model.User;
import com.spring.service.UserService;


@Controller
//@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userservice;
	
	 @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + user.getLastname());
	 
	        if (userservice.isUserExist(user)) {
	            System.out.println("A User with name " + user.getLastname() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        userservice.addUser(user);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{userid}").buildAndExpand(user.getUserid()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 @RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<User>> listusers() {
	        List<User> users = userservice.listusers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	    }
	 
	 
	
}
