package com.revature.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FailServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    PrintWriter pw = response.getWriter();
    pw.write("<p>YOU FAILED</p>");

    RequestDispatcher rd = request.getRequestDispatcher("Views/fail.html");
    rd.include(request,response);
    //rd.forward(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    //do something
    doGet(request, response);
  }
} 
