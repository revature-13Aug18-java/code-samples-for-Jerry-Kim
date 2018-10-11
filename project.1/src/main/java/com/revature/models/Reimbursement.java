package com.revature.models;
import java.math.BigDecimal;

public class Reimbursement {
  public static final int PENDING = 0;
  public static final int APPROVED = 1;
  public static final int REJECTED = 2;
  
  private int id;
  private String name;
  private String author; 
  private String description;
  private BigDecimal amt; 
  private int status; 
 
  public Reimbursement() {
  }
  public Reimbursement(String name, String author, String description, BigDecimal amt) {
    super();
    this.name = name;
    this.author = author;
    this.description = description;
    this.amt = amt;
    this.status = PENDING;
  }

  public Reimbursement(String name, String author, String description, BigDecimal amt, int status) {
    super();
    this.name = name;
    this.author = author;
    this.description = description;
    this.amt = amt;
    this.status = status;
  }
  public int getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getAuthor() {
    return author;
  }
  public String getDescription() {
    return description;
  }

  public BigDecimal getAmt() {
    return amt;
  }

  public int getStatus() {
    return status;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setAuthor(String author) {
    this.author = author;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setAmt(BigDecimal amt) {
    this.amt = amt;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  


}
