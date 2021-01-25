package com.example.app.service;

import java.util.Map;

import com.example.app.model.UserFeature;

public interface UserFeatureService {

	public UserFeature findByUserEmailAndFeatureName(Map<String, Object> params);
	public void updateAccess(Map<String, Object> params);
	
}
