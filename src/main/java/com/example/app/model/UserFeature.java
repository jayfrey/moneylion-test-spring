package com.example.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_feature")
public class UserFeature {

  @Id 
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "feature_id")
  private Feature feature;

 
  @Column(name = "access")
  private boolean access;

  public UserFeature() {}

  public boolean getAccess()
  {
    return this.access;
  }

  public void setAccess(boolean access)
  {
    this.access = access;
  }

  @Override
  public String toString() 
  {
     return "{" + "id=" + this.id + ", user_id='" + user.getEmail() + '\'' + ", feature_id='" + feature.getName() + '\'' + ", access='" + this.access + '\'' + '}';
  }
}