package com.sadi.a2.dao;

import com.sadi.a2.model.User;

public interface UserDao {

	void save(User user);
	
	User findById(int id);
	
	User findBySSO(String sso);
	
}

