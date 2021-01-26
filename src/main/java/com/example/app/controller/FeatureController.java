package com.example.app.controller;

import java.lang.invoke.MethodHandles;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Feature;
import com.example.app.model.Request;
import com.example.app.model.UserFeature;
import com.example.app.service.FeatureService;
import com.example.app.service.UserFeatureService;

@RestController
@Validated
public class FeatureController {
	
	@Autowired
	private FeatureService featureService;
	
	@Autowired
	private UserFeatureService userFeatureService;
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
	
	@GetMapping("/feature/all")
	public List<Feature> all() {
		return featureService.fetchAll();
	}

	@GetMapping("/feature")
	public ResponseEntity<Object> getAccess(@RequestParam Map<String, Object> params) 
	{
		logger.info("Request: " + params);
		try {
			UserFeature userFeature = userFeatureService.findByUserEmailAndFeatureName(params);
			Map<String,Object> data = Collections.singletonMap("canAccess", userFeature.getAccess());
			ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.OK).body(data);
			logger.info("Response: ", response);
			return response;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
		}
	}
	
	@PostMapping("/feature")
	public ResponseEntity<Object> updateAccess(@Valid @RequestBody Request request)
	{
		logger.info("Request: " + request.toString());
		try {
			userFeatureService.updateAccess(request.toMap(request));
			logger.info("Update access successfully!");
			ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.OK).body("");
			logger.info("Response: ", response);
			return response;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("");
		}
	}

}