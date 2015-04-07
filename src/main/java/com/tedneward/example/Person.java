package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implments Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static int count;
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    ssn = "";
    count++;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if (age < 0) {
      throw new IllegalArgumentException;
    }
    this.age = age;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException;
    }
    this.name = name;
  }

  public int count() {
    return count;
  }
  
  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = value;
  }
  
  public String getSSN() {
    return ssn;
  }
  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public void setPropertyChangeFired(boolean propertyChangeFired) {
    this.propertyChangeFired = propertyChangeFired;
  } 

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public boolean equals(Person other) {
    if (other instanceof Person) {
      Person o = (Person) other;
      return this.name.equals(o.getName()) && this.age == o.getAge();
    } else {
      return false;
    }
  }

  public static class AgeComparator implements Comparator<Person>{
    public int compare(Person p1,Person p2) {
      return p1.getAge() - p2.getAge();
    }
  }

  @Override
  public int compareTo(Person o) {
    if (this.getSalary() > o.getSalary()) {
      return -1;
    } else if (this.getSalary() < o.getSalary()) {
      return  1;
    } else {
      return 0;
    }
  }

  @Override
  public String toString() {
    return ("[Person name:" + this.name + " age:" + this.age + " salary:" + this.salary + "]");
  }

  public static ArrayList<Person> getNewardFamily() {
    ArrayList<Person> fam = new ArrayList<Person>();
    fam.add(new Person("Ted",41,250000.));
    fam.add(new Person("Charlotte",43,150000.));
    fam.add(new Person("Michael",22,10000.));
    fam.add(new Person("Matthew",15,0.));
    return fam;
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
