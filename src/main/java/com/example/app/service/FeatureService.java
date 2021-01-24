package com.example.app.service;

import java.util.List;

import com.example.app.model.Feature;

public interface FeatureService {

	public List<Feature> fetchAll();
	public Feature findByName(String name);
}
