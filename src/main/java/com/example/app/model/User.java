package com.example.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

  @Id 
  @GeneratedValue
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @OneToMany(mappedBy = "user")
  private Set<UserFeature> userFeature;

  public User() {}

  public User(String name, String email)
  {
    this.name = name;
    this.email = email;
  }

  public Long getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

   @Override
   public String toString() 
   {
     return "{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='" + this.email + '\'' + '}';
   }
}