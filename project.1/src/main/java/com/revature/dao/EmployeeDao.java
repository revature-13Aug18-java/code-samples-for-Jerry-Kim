package com.revature.dao;
import com.revature.models.Employee;
import java.util.List;
public interface EmployeeDao {
  public List<Employee> getEmployees();
  public Employee getEmployeeByUsername(String username);
  public int updateEmployee(Employee emp);
  public int createEmployee(Employee emp);
  public int deleteEmployeeByUsername(String username);
}
