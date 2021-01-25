package com.example.app.service;

import java.lang.invoke.MethodHandles;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.UserFeature;
import com.example.app.repository.UserFeatureRepository;

@Service
public class UserFeatureServiceImp implements UserFeatureService {

	@Autowired
	private UserFeatureRepository userFeatureRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public UserFeature findByUserEmailAndFeatureName(Map<String, Object> params) 
	{
		logger.info("Params: " + params);
		String email = (String)params.get("email"); 
		String featureName = (String)params.get("featureName");
		UserFeature record = userFeatureRepo.findByUserEmailAndFeatureName(email, featureName);
		logger.info("Return: " + record);
		return record;
	}
	
	public void updateAccess(Map<String, Object> params) 
	{
		logger.info("Params: " + params);
		UserFeature userFeature = findByUserEmailAndFeatureName(params);
		Boolean access =(Boolean)params.get("enable");
		userFeature.setAccess(access);
		userFeatureRepo.save(userFeature);
		logger.info("Done updating user access!");
	}
}
