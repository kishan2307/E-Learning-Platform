package com.sadi.a2.dao;

import java.util.List;

import com.sadi.a2.model.UserProfile;

public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
