package com.example.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Feature;
import com.example.app.repository.FeatureRepository;
import com.example.app.repository.UserFeatureRepository;
import com.example.app.exception.UserNotFoundException;
import com.example.app.AppApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class FeatureController {

  private final FeatureRepository repository;
  private final UserFeatureRepository userFeatureRepository;
  private static final Logger LOGGER = LoggerFactory.getLogger(AppApplication.class);

  FeatureController(FeatureRepository repository, UserFeatureRepository userFeatureRepository) 
  {
    this.repository = repository;
    this.userFeatureRepository = userFeatureRepository;
  }

  @GetMapping("/features")
  List<Feature> all() 
  {
    return repository.findAll();
  }

  @PostMapping("/feature")
  Feature newFeature(@RequestBody Feature newFeature) 
  {
    return repository.save(newFeature);
  }

  // Single item

  @GetMapping("/feature/{id}")
  Feature one(@PathVariable Long id) 
  {
    LOGGER.info("Features get {}", id);
    LOGGER.info("Features get {}", id);
    return repository.findById(id)
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  @GetMapping("/feature")
  @ResponseBody
  public String getAccess(@RequestParam Map<String,String> allParams) 
  {
    LOGGER.info("Features get", allParams);
    return "Features get" + allParams;
  }

  @PutMapping("/feature/{id}")
  Feature replaceFeature(@RequestBody Feature newFeature, @PathVariable Long id)
  {
    return repository.findById(id)
      .map(feature -> {
        feature.setName(newFeature.getName());
        return repository.save(feature);
      })
      .orElseGet(() -> {
        newFeature.setId(id);
        return repository.save(newFeature);
      });
  }

  @DeleteMapping("/feature/{id}")
  void deleteFeature(@PathVariable Long id) 
  {
    repository.deleteById(id);
  }
}