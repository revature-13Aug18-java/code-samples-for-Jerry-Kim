package com.revature.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.revature.dao.*;
import com.revature.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.revature.models.Employee.MANAGER_TITLE;
public class ProfileDataServlet extends HttpServlet {
  private static final long serialVersionUID = 2L;
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    PrintWriter pw = response.getWriter();
    ObjectMapper om = new ObjectMapper();
    HttpSession session = request.getSession(false);
    String targetUsername = request.getParameter("targetUsername");
    EmployeeDaoImpl ed = new EmployeeDaoImpl();
    Employee emp = ed.getEmployeeByUsername(targetUsername);
    if(targetUsername != null) 
      pw.write(om.writeValueAsString(emp));
  }
}
