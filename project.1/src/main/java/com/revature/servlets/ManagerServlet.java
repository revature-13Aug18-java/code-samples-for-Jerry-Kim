package com.revature.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ManagerServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(false);
    if(session != null && session.getAttribute("title").equals("manager"))
    {
      String username = (String) session.getAttribute("username");
      String title = (String) session.getAttribute("title");
      PrintWriter pw = response.getWriter();
      RequestDispatcher rd = request.getRequestDispatcher("/Views/manager.html");
      rd.include(request, response);
    }
    else {
      response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    doGet(request, response);
  }
}

