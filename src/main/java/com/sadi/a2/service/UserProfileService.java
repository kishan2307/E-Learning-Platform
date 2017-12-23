package com.sadi.a2.service;

import java.util.List;

import com.sadi.a2.model.UserProfile;

public interface UserProfileService {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
