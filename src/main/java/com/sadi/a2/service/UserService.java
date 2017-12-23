package com.sadi.a2.service;

import com.sadi.a2.model.User;

public interface UserService {

	void save(User user);
	
	User findById(int id);
	
	User findBySso(String sso);
	
}