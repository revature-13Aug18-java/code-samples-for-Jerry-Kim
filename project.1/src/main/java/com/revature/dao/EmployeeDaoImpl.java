package com.revature.dao;
import com.revature.models.Employee;
import java.util.Date;
import com.revature.util.ConnectionUtil;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.sql.SQLException;
import java.io.IOException;

public class EmployeeDaoImpl implements EmployeeDao {
  protected static final String EMP_TABLE = "EMPLOYEESTRIMMED"; 
  public List<Employee> getEmployees() {
    String sql = "SELECT * from " + EMP_TABLE;
    List<Employee> emps = new ArrayList<Employee>();
    try(Connection con = ConnectionUtil.getConnection(); 
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql))
    {
        while(rs.next()) {
          Employee emp = new Employee();
          emp.setUsername(rs.getString("USERNAME"));
          emp.setFirstName(rs.getString("FIRSTNAME"));
          emp.setLastName(rs.getString("LASTNAME"));
          emp.setPassword(rs.getString("password")); //TODO make password field in Employees table
          emp.setManager(rs.getString("manager"));
          emp.setTitle(rs.getString("TITLE"));
          //System.out.println("DATE" + rs.getDate("startDate"));
// java.sql.Date dbSqlDate = rs.getDate("startDate");
//    java.util.Date dbSqlDateConverted = new java.util.Date(dbSqlDate.getTime());
//    System.out.println(dbSqlDateConverted);
//         emp.setStartDate(dbSqlDateConverted);  
          emps.add(emp);
        } 
    }
    catch (IOException | SQLException e) {
      e.printStackTrace();
    }
    return emps; 
  }  

  public Employee getEmployeeByUsername(String username) {
    String sql = "SELECT * from " + EMP_TABLE + " where username = ?";
    System.out.println(sql);
    Employee emp = new Employee();
    try(Connection con = ConnectionUtil.getConnection(); 
        PreparedStatement stmt = con.prepareStatement(sql))
    {
        stmt.setString(1, username);
        try ( ResultSet rs = stmt.executeQuery()) {
          if(rs.next()) {
            emp.setUsername(rs.getString("USERNAME"));
            emp.setPassword(rs.getString("PASSWORD"));
            emp.setFirstName(rs.getString("FIRSTNAME"));
            emp.setLastName(rs.getString("LASTNAME"));
            emp.setManager(rs.getString("MANAGER"));
            //System.out.println("EMP DAO IMPL " + rs.getString("REPORTSTO"));
            emp.setTitle(rs.getString("TITLE"));
            //emp.setStartDate(new Date(rs.getString("startDate")));
          }
          else {
            emp = null;
          }
        }
    }
    catch (IOException | SQLException e) {
      e.printStackTrace();
    }
    return emp; 
  }
 public int updateEmployee(Employee emp) {
    return 0;
  }
  public int createEmployee(Employee emp) {
    return 0;
  }
  public int deleteEmployeeByUsername(String username) {
    return 0;
  }
}
