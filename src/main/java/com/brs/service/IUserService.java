package com.brs.service;

import java.util.List;

import com.brs.entity.Bus;
import com.brs.entity.User;

public interface IUserService {
	
	public User addUser(User user) throws Exception;
	public User updateUser(User user) throws Exception;
	public User deleteUser(int userId)throws Exception;
	public User viewUser(int userId) throws Exception;
	public List<User> viewAllUsers()throws Exception;

}
