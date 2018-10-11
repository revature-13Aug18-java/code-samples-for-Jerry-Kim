package com.revature.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.revature.dao.*;
import com.revature.models.*;
import java.math.*;
import static com.revature.models.Employee.MANAGER_TITLE;

//maps to /employee/request ; parameters: action => view | new
public class NewRequestServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter pw = response.getWriter();

    HttpSession session = request.getSession(false);
    String sessionUsername = (String) session.getAttribute("username");
    EmployeeDaoImpl ed = new EmployeeDaoImpl();
    Employee emp = ed.getEmployeeByUsername(sessionUsername);
    if(emp != null && session != null) {
        String action = request.getParameter("action");
        if(action != null) {
          switch(action) {
            case "new": 
              request.getRequestDispatcher("/Views/newRequest.html").forward(request, response);
              break;
            case "view":
              request.getRequestDispatcher("/Views/viewRequests.html").forward(request, response);
              break;
            default:
             response.sendRedirect("/employee/request"); 
             break;
          }
        }
    }
    else {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    doGet(request, response);
  }

}

