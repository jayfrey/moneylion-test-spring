package com.example.app.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Feature {

  private @Id @GeneratedValue Long id;
  private String name;
  private String email;

  Feature() {}

  Feature(String name)
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

  // @Override
  // public boolean equals(Object o) {

  //   if (this == o)
  //     return true;
  //   if (!(o instanceof Employee))
  //     return false;
  //   Employee employee = (Employee) o;
  //   return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
  //       && Objects.equals(this.role, employee.role);
  // }

  // @Override
  // public int hashCode() {
  //   return Objects.hash(this.id, this.name, this.role);
  // }

  // @Override
  // public String toString() {
  //   return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
  // }
}