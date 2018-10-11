package com.revature.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.revature.dao.*;
import com.revature.models.*;
import java.util.*;
import java.math.BigDecimal;
import static com.revature.models.Employee.MANAGER_TITLE;
/*
   if manager requesting view profile of employee, verify title=manager, get username from query parameter, set that as target username
   */
public class ProfileServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter pw = response.getWriter();

    HttpSession session = request.getSession(false);
Enumeration attributeNames =  session.getAttributeNames();
while (attributeNames.hasMoreElements()) {
    String name = (String) attributeNames.nextElement();
    String value = (String) session.getAttribute(name);
    System.out.println(name + "=" + value);
}

    if(session != null) {

      String sessionUsername = (String) session.getAttribute("username");
      String sessionTitle = (String) session.getAttribute("title");
      
      EmployeeDaoImpl ed = new EmployeeDaoImpl();
      Employee emp = ed.getEmployeeByUsername(sessionUsername);
      if(sessionTitle.equals("manager")) {
        String targetUsername = request.getParameter("username");
        session.setAttribute("targetUsername", targetUsername);
        pw.write("<h1>" + (String) session.getAttribute("targetUsername") + "</h1>");
      }  
      else {
        pw.write("<h1> NOT MANAGER " + (String) session.getAttribute("targetUsername") + "</h1>");
      }

      request.getRequestDispatcher("/Views/profile.html").forward(request, response);
    }
  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    //doGet(request, response);
    PrintWriter pw = response.getWriter();
    String pathInfo = request.getPathInfo();
    String pathTranslated = request.getPathTranslated();
    String contextPath = request.getContextPath();

    HttpSession session = request.getSession(false);
    String parameter = request.getParameter("username");
    if(parameter == null) {
      parameter = pathInfo.split("/")[1];
      // pw.write(parameter);
    }
    EmployeeDaoImpl ed = new EmployeeDaoImpl();
    Employee emp = ed.getEmployeeByUsername(parameter);
    //pw.write("Parameter: " + parameter);
    if(emp == null) {
      response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    if((session != null)) { 
      if (session.getAttribute("username").equals(parameter) || session.getAttribute("title").equals(MANAGER_TITLE)) {
        String[] actionParameters = pathInfo.split("/"); 
        int ln = actionParameters.length;
        String p1 = actionParameters[ln-1];
        if(p1.equals("new")) {
          //create 
         // Enumeration<String> names = session.getAttributeNames();

          //write session attributes as json

          String requestName = (String) request.getParameter("name"); 
          String sessionUsername = (String) session.getAttribute("username");
          String requestDescription = (String) request.getParameter("description"); 
          String requestAmt = (String) request.getParameter("amt");
          
          ReimbursementDaoImpl rd = new ReimbursementDaoImpl();
          rd.createReimbursement(requestName, sessionUsername, requestDescription, new BigDecimal(requestAmt));
          request.getRequestDispatcher("/Views/profile.html").forward(request, response);
        }
        else {
          request.getRequestDispatcher("/Views/profile.html").include(request, response);
        }
      }
      else {
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
      }
    }
    else {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

  }

}

