package com.revature.models;
import java.util.Date;

public class Employee {
  public static final String MANAGER_TITLE = "manager";
  public static final String EMPLOYEE_TITLE = "employee";

  private int employeeId;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String manager;
  private String title;
  private int departmentId;
  private Date startDate;
  
  public Employee() {
    super();
  }

  public Employee(int employeeId, String username, String password, String firstName, String lastName, String manager, String title, int departmentId, Date startDate) {
    this.employeeId=employeeId;
    this.username=username;
    this.password=password;
    this.firstName=firstName;
    this.lastName=lastName;
    this.manager=manager;
    this.title=title;
    this.departmentId=departmentId;
    this.startDate=startDate;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId=employeeId;
  }
  public void setUsername(String username) {
    this.username=username;
  }
  public void setPassword(String password) {
    this.password=password;
  }
  public void setFirstName(String firstName) {
    this.firstName=firstName;
  }
  public void setLastName(String lastName) {
    this.lastName=lastName;
  }
  public void setManager(String manager) {
    this.manager=manager;
  }
  public void setDepartmentId(int departmentId) {
    this.departmentId=departmentId;
  }

  public void setStartDate(Date startDate) {
    this.startDate=startDate;
  }
  public void setTitle(String title) {
    this.title=title;
  }
  public String getFirstName() {
    return firstName;
  }
  
  public String getLastName() {
    return lastName;
  }

  public String getUsername() {
    return username;
  }

  public String getTitle()  {
    return title;
  }

  public Date getStartDate() {
    return startDate;
  }
 
  public int getEmployeeId() {
    return employeeId;
  } 

  public String getPassword() {
    return password;
  }

  public int getDepartmentId() {
    return departmentId;
  }
  
  public String getManager() {
    return manager;
  }
    
  @Override
  public String toString() {
    return "firstName: " + firstName;
  }
}
