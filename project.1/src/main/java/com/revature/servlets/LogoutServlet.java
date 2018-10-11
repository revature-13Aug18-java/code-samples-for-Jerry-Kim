package com.revature.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LogoutServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    HttpSession session = request.getSession();
    PrintWriter pw = response.getWriter();
    if(session != null) {
      session.invalidate();
    }
    pw.write("logged out");
    pw.write(request.getContextPath());
    response.sendRedirect("login");
  }
}
