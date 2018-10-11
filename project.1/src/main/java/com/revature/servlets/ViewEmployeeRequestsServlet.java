package com.revature.servlets;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.models.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


//maps to /manager/request
public class ViewEmployeeRequestsServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    //request.getRequestDispatcher("/Views/managerViewRequests.html").forward(request, response);
    HttpSession session = request.getSession(false);
    String sessionUsername = (String) session.getAttribute("targetUsername");
    EmployeeDaoImpl ed = new EmployeeDaoImpl();
    Employee emp = ed.getEmployeeByUsername(sessionUsername);
    if(emp != null && session != null) {
        String action = request.getParameter("action");
        if(action != null) {
          switch(action) {
            case "view":
              request.getRequestDispatcher("/Views/managerViewRequestOne.html").forward(request, response);
              break;
            default:
             response.sendRedirect("/manager/request"); 
             break;
          }
        }
    }
  }
}
