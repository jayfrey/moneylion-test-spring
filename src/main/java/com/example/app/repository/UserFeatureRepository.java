package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.app.model.UserFeature;

@Repository
public interface UserFeatureRepository extends JpaRepository<UserFeature, Long> {
	
//	@Query("select uf from UserFeature uf where uf.userId = :userId and uf.featureId = :featureId")
	UserFeature findByUserIdAndFeatureId(@Param("userId") Long userId, @Param("featureId") Long featureId);

}