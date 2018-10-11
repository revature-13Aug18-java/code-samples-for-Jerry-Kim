package com.revature.servlets;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/*servlet to help with requests for session info
  client makes a get request with ajax and this returns whether user already has session, specified in request header. 
  */

public class SessionServlet extends HttpServlet {
 private static final long serialVersionUID = 3L;

  public SessionServlet() {
    super();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    HttpSession session = request.getSession(false);

      PrintWriter pw = response.getWriter();
      if(session != null) {
      
        Enumeration<String> names = session.getAttributeNames();

        //write session attributes as json
        pw.write("{");
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = (String) session.getAttribute(name);
            pw.write("\"" + name + "\":\"" + value + "\"");
            if(names.hasMoreElements()) {
              pw.write(",");
            }
        }
        pw.write("}");

      }
      else {
        pw.write("{\"username\" : null }");
      }
      pw.close();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    doGet(request, response);
  }
}
