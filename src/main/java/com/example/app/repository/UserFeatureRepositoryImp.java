package com.example.app.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserFeatureRepositoryImp {

//	EntityManager em;
//	
//	List<UserFeature> findByUserEmailAndFeatureName(String name, String featureName) {
//		
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//	    CriteriaQuery<UserFeature> cq = cb.createQuery(UserFeature.class);
//	    Root<UserFeature> userFeature = cq.from(UserFeature.class);
//	    
//	    cq.select(userFeature).where(cb.equal(userFeature.get("access"), true));
//	    
////	    Query<UserFeature> query = em.createQuery(cq);
//	    TypedQuery<UserFeature> query = em.createQuery(cq);
//
//		return query.getResultList();
//	}
}
