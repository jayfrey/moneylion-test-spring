package com.example.app.service;

import java.util.Map;

import com.example.app.model.UserFeature;

public interface UserFeatureService {

	public UserFeature findByUserIdAndFeatureId(Map<String, String> params);
	public void updateAccess(Map<String, String> params);
	
}
