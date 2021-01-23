package com.example.app.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;

@Entity
public class UserFeature {

  @EmbeddedId
  UserFeatureKey id;

  @ManyToOne
  @MapsId("userId")
  @JoinColumn(name = "user_id")
  User user;

  @ManyToOne
  @MapsId("featureId")
  @JoinColumn(name = "feature_id")
  Feature feature;

  boolean access;

  UserFeature() {}

}