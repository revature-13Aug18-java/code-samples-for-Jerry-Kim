package com.revature.dao;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
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
import static com.revature.dao.EmployeeDaoImpl.EMP_TABLE;

public class ReimbursementDaoImpl {
  protected static final String REIM_TABLE = "reimbursements";
  public List<Reimbursement> getReimbursements() {
    String sql = "SELECT * from " + REIM_TABLE;
    List<Reimbursement> reims = new ArrayList<Reimbursement>();
    try(Connection con = ConnectionUtil.getConnection(); 
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql))
    {
      while(rs.next()) {
        Reimbursement reim = new Reimbursement();
        reim.setId(rs.getInt("id"));
        reim.setName(rs.getString("name"));
        reim.setAuthor(rs.getString("author"));
        reim.setDescription(rs.getString("description"));
        reim.setAmt(rs.getBigDecimal("amt")); 
        reim.setStatus(rs.getInt("status"));
        reims.add(reim);
      } 
    }
    catch (IOException | SQLException e) {
      e.printStackTrace();
    }
    return reims; 
  }
  public List<Reimbursement> getReimbursements(String author) {

    String sql = "SELECT * from " + REIM_TABLE + " where author = ?";
    List<Reimbursement> reims = new ArrayList<Reimbursement>();
    try(Connection con = ConnectionUtil.getConnection(); 
        PreparedStatement stmt = con.prepareStatement(sql))
    {
      stmt.setString(1, author);
      ResultSet rs = stmt.executeQuery();
      while(rs.next()) {
        Reimbursement reim = new Reimbursement();
        reim.setId(rs.getInt("id"));
        reim.setName(rs.getString("name"));
        reim.setAuthor(rs.getString("author"));
        reim.setDescription(rs.getString("description"));
        reim.setAmt(rs.getBigDecimal("amt")); 
        reim.setStatus(rs.getInt("status"));
        reims.add(reim);
      } 
    }
    catch (IOException | SQLException e) {
      e.printStackTrace();
    }
    return reims; 
  }

  public Reimbursement getReimbursementById(int id) {
    String sql = "SELECT * from " + REIM_TABLE + " WHERE ID=?";
    Reimbursement reim = null; 
    try(Connection con = ConnectionUtil.getConnection(); 
        PreparedStatement stmt = con.prepareStatement(sql))
        {
          stmt.setInt(1, id);        
          try(ResultSet rs = stmt.executeQuery()) {
      if(rs.next()) {
        reim = new Reimbursement();
        reim.setId(rs.getInt("id"));
        reim.setName(rs.getString("name"));
        reim.setAuthor(rs.getString("author"));
        reim.setDescription(rs.getString("description"));
        reim.setAmt(rs.getBigDecimal("amt")); 
        reim.setStatus(rs.getInt("status"));
      } 
          }
    catch(SQLException e) {
      e.printStackTrace();
    }
        }
    catch (IOException | SQLException e) {
      e.printStackTrace();
    }
    return reim;
  }
  public int updateReimbursement(Reimbursement r) {
    return 0;
  }
  public int createReimbursement(Reimbursement r) {
    return 0;
  }
  public int createReimbursement(String name, String author, String description, BigDecimal amt) {
    String sql = "Insert into " + "reimbursements" + "(name, author, description, amt) values(?, ?, ?, ?)";
    System.out.println(sql);

    try(Connection con = ConnectionUtil.getConnection(); 
        PreparedStatement stmt = con.prepareStatement(sql))
    {
      stmt.setString(1, name);
      stmt.setString(2, author);
      stmt.setString(3, description);
      stmt.setBigDecimal(4, amt);

      stmt.executeUpdate();  
    }
    catch (IOException | SQLException e) {
      e.printStackTrace();
    }
    return 0; 
  }
  public int deleteReimbursement(int id) {
    return 0;
  }
  public int updateStatus(int id, int status) {
    String sql = "update reimbursements set status=? where id=?";
    int rowsAffected = -1;
    try(Connection con = ConnectionUtil.getConnection(); 
        PreparedStatement stmt = con.prepareStatement(sql))
        {
          stmt.setInt(1, status);
          stmt.setInt(2, id);        
          rowsAffected = stmt.executeUpdate();
        }
    catch (IOException | SQLException e) {
      e.printStackTrace();
    }
    return 430;
  }
}
