package com.example.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "feature")
public class Feature {

  @Id 
  @GeneratedValue
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "feature")
  private Set<UserFeature> userFeature;

  public Feature() {}

  public Feature(String name)
  {
    this.name = name;
  }

  public Long getId() 
  {
    return this.id;
  }

  public String getName() 
  {
    return this.name;
  }

  public void setId(Long id) 
  {
    this.id = id;
  }

  public void setName(String name) 
  {
    this.name = name;
  }

  @Override
  public String toString() {
    return "{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
  }
}