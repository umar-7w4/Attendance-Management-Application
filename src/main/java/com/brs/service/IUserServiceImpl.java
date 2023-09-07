package com.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.entity.Route;
import com.brs.entity.User;
import com.brs.repository.IUserRepository;

@Service("IUserService")
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepository iUserRepository;

	@Override
	public User addUser(User user) throws Exception {
		iUserRepository.saveAndFlush(user);
		return user;
	}

	@Override
	public User updateUser(User user) throws Exception {
		User  bean = null;
		try {
			bean = iUserRepository.findById(user.getUserLoginId()).get();
		}
		catch(Exception e) {
			throw new Exception("Route details not found!");
		}
		iUserRepository.saveAndFlush(user);
		return bean;
	}

	@Override
	public User deleteUser(int userId) throws Exception {
		User  bean = null;
		try {
			bean = iUserRepository.findById(userId).get();
		}
		catch(Exception e) {
			throw new Exception("User details not found!");
		}
		iUserRepository.deleteById(userId);
		return bean;
	}

	@Override
	public User viewUser(int userId) throws Exception {
		User  bean = null;
		try {
			bean = iUserRepository.findById(userId).get();
		}
		catch(Exception e) {
			throw new Exception("User details not found!");
		}
		return bean;
	}

	@Override
	public List<User> viewAllUsers() throws Exception {
		return iUserRepository.findAll();
	}

}
