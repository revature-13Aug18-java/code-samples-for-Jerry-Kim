package com.revature.dao;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import java.math.BigDecimal;
import java.util.List;

public interface ReimbursementDao {
  public List<Reimbursement> getReimbursements();
  public List<Reimbursement> getReimbursements(String author);
  public Reimbursement getReimbursementById(int id);
  public int updateReimbursement(Reimbursement r);
  public int createReimbursement(Reimbursement r);
  public int createReimbursement(String name, String author, String description, BigDecimal amt);
  public int deleteReimbursement(int id);
  public int updateStatus(int id, int status);
}
