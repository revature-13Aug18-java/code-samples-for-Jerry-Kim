package com.revature.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.revature.dao.*;
import com.revature.models.*;
import static com.revature.models.Employee.MANAGER_TITLE;

public class ViewRequestsServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/Views/viewRequests.html").forward(request, response);

  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    doGet(request, response);
  }

}

