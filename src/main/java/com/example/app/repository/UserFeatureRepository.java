package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.UserFeature;

public interface UserFeatureRepository extends JpaRepository<UserFeature, Long> {
	
	UserFeature findByUserEmailAndFeatureName(String name, String featureName);
}