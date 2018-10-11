package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.revature.dao.*;
import com.revature.models.*;
import java.math.*;
import static com.revature.models.Employee.MANAGER_TITLE;

//mapped to /data/requests
//parameters: who => all | <username>; filter => approved | pending | rejected
public class RequestsDataServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    PrintWriter pw = response.getWriter();
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    String reimsString = "";
    ReimbursementDaoImpl rd = new ReimbursementDaoImpl();
    ObjectMapper om = new ObjectMapper();

    String who = request.getParameter("who");
    if(who != null) {
      if(who.equals("all")) {
        List<Reimbursement> reims = rd.getReimbursements();
        reimsString = "{\"Reimbursements\": " + om.writeValueAsString(reims) + "}";
        pw.write(reimsString);
      }
      else { //else who; get reims by username
        List<Reimbursement> reims = rd.getReimbursements(who);
        reimsString = "{\"Reimbursements\": " + om.writeValueAsString(reims) + "}";
        pw.write(reimsString);
      }
    }
  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
      String id = request.getParameter("id");
      String action = request.getParameter("action");
      PrintWriter pw = response.getWriter();
      HttpSession session = request.getSession(false);
      if(id != null && action != null) {
        //TODO
      }
      
      ReimbursementDaoImpl reimd = new ReimbursementDaoImpl();
      int rowsAffected = -1;
      String updatedStatus = "";
      if(action.equals("approve")) {
        rowsAffected = reimd.updateStatus(Integer.parseInt(id), Reimbursement.APPROVED);
        updatedStatus = "approved";
      }
      else if(action.equals("reject")) {
        rowsAffected = reimd.updateStatus(Integer.parseInt(id), Reimbursement.REJECTED); 
        updatedStatus = "rejected";
      }
      String manager = (String) session.getAttribute("username");
      pw.write("{\"id\":" + id + ", \"manager\":\"" + manager + "\", \"updatedStatus\": \"" + updatedStatus + "\" }");
  }
}

