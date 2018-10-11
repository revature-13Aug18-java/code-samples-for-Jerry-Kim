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

public class EmployeesViewServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    HttpSession session = request.getSession(false);
    if(session != null) {
      String title = (String) session.getAttribute("title");
      if(title.equals(MANAGER_TITLE)) {
          request.getRequestDispatcher("/Views/roster.html").forward(request, response);
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
