package com.revature.servlets;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.revature.models.*;
import com.revature.dao.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.revature.models.Employee.MANAGER_TITLE;
//import com.google.code.*;
//maps to data/profile ; params: who => [all] | <username>
public class EmployeesDataServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String who = request.getParameter("who");
    EmployeeDao ed = new EmployeeDaoImpl();
    ObjectMapper om = new ObjectMapper();
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    PrintWriter pw = response.getWriter();
    String empsString = "";
    if(who != null && !(who.equals("all"))) {
      Employee emp = ed.getEmployeeByUsername(who); 
      empsString = "{\"Employee\": " + om.writeValueAsString(emp) + "}";
      pw.write(empsString);
    }
    else {
      List<Employee> emps = ed.getEmployees();
      empsString = "{\"Employees\": " + om.writeValueAsString(emps) + "}";
      pw.write(empsString);
    }

  } 
}
