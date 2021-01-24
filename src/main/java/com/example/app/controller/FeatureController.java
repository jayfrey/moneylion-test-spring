package com.example.app.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Feature;
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
	
	@GetMapping("/feature/all")
	public List<Feature> all() {
		return featureService.fetchAll();
	}

	@GetMapping("/feature")
	@ResponseBody
	public ResponseEntity<Object> getAccess(@RequestParam Map<String, String> params) 
	{
		try {
			UserFeature userFeature = userFeatureService.findByUserIdAndFeatureId(params);
			return ResponseEntity.status(HttpStatus.OK).body(
		            Collections.singletonMap("canAccess", userFeature.getAccess()));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
		}
	}
	
	@PostMapping("/feature")
	@ResponseBody
	public ResponseEntity<Object> updateAccess(@RequestBody Map<String, String> params) 
	{
		try {
			userFeatureService.updateAccess(params);
			return ResponseEntity.status(HttpStatus.OK).body("");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("");
		}
	}

}