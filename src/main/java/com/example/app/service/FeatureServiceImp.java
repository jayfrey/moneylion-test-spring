package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Feature;
import com.example.app.repository.FeatureRepository;

@Service
public class FeatureServiceImp implements FeatureService {

	@Autowired
	private FeatureRepository featureRepo;
	
	public List<Feature> fetchAll() 
	{
		return featureRepo.findAll();
	}
	
	public Feature findByName(String name) 
	{
		return featureRepo.findByName(name);
	}
}
