package com.example.app.repository;

import com.example.app.model.UserFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFeatureRepository extends JpaRepository<UserFeature, Long> 
{
	@Query("select u from User u where u.email = ?1")
 	User findByEmailAddress(String email);
}