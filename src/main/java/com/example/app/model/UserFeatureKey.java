package com.example.app.model;

import javax.persistence.Embeddable;
import javax.persistence.Column;

import java.io.Serializable;

@Embeddable
public class UserFeatureKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "feature_id")
    Long featureId;

}

