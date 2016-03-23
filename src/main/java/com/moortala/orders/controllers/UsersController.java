package com.moortala.orders.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.moortala.orders.model.Users;
import com.moortala.orders.model.UsersDao;

@RestController
@RequestMapping("capstone/users")
public class UsersController {
	private Users myUser;
	
	//all users
		@RequestMapping(method=RequestMethod.GET)
		@ResponseBody
		public Iterable<Users> getUsers(){
			    Iterable<Users> myUser = userDao.findAll();
			      return myUser;
		}
	
		//create a user
		@RequestMapping(value="/create")
		@ResponseBody
		public Users newUser(String userName, String password, Long userType){
			//order;// = null;  
			    //  order = new Orders();
			myUser = new Users();
			myUser.setUser(userName);
			myUser.setPassword(password);
			myUser.setUserType(userType);
			userDao.save(myUser);
			      return myUser;
		}
		//find a user
		@RequestMapping(value="findUser/{userName}")
		@ResponseBody
		public Users findUser(@PathVariable("userName") String userName){
			 List<Long> ids = null;
		      try {
		    	   ids = userDao.findUserByName(userName);
		    	   myUser = userDao.findOne(ids.get(0));
			} catch (Exception e) {
				e.printStackTrace();
				return myUser;
			}
			return myUser;
		}
	//wire the DAO
	@Autowired
	  private UsersDao userDao;
}
