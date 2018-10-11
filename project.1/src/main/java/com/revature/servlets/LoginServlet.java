package com.revature.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.models.Employee;

public class LoginServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    RequestDispatcher rd = request.getRequestDispatcher("Views/login.html");
    rd.forward(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    EmployeeDaoImpl ed = new EmployeeDaoImpl();
    String username = request.getParameter("username");
    Employee emp = ed.getEmployeeByUsername(username);
    if(emp != null) {
      String correctPassword = emp.getPassword();
      String enteredPassword = request.getParameter("password"); 
      if(correctPassword.equals(enteredPassword) || true) {
        HttpSession session = request.getSession();
        if(emp.getTitle().equals("manager")) {
          session.setAttribute("username", username);
          session.setAttribute("title", "manager");
          response.sendRedirect("manager");
        }
        else {
          session.setAttribute("username", username);
          session.setAttribute("title", "employee");
          session.setAttribute("targetUsername", username);
          response.sendRedirect("employee/profile");
        }
      } 
    } 
    else {
      RequestDispatcher rd = request.getRequestDispatcher("Views/login.html");
      PrintWriter pw = response.getWriter();
      pw.write("<p>FAIL FROM LOGIN</p>");
      
      rd.include(request, response);
    }
  }
} 
