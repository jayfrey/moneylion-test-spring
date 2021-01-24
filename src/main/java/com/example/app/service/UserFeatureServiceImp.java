package com.example.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Feature;
import com.example.app.model.User;
import com.example.app.model.UserFeature;
import com.example.app.repository.UserFeatureRepository;

@Service
public class UserFeatureServiceImp implements UserFeatureService {

	@Autowired
	private UserFeatureRepository userFeatureRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FeatureService featureService;
	
	public UserFeature findByUserIdAndFeatureId(Map<String, String> params) 
	{
		User user = userService.findByEmail(params.get("email"));
		Feature feature = featureService.findByName(params.get("featureName"));
		return userFeatureRepo.findByUserIdAndFeatureId(user.getId(), feature.getId());
	}
	
	public void updateAccess(Map<String, String> params) 
	{
		UserFeature userFeature = findByUserIdAndFeatureId(params);
		userFeature.setAccess(Boolean.parseBoolean(params.get("enable")));
		userFeatureRepo.save(userFeature);
	}
}
