package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.app.model.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
	
	@Query("select f from Feature f where f.name = ?1")
 	Feature findByName(String name);
}