package com.revature.util;

import java.io.*;
import java.sql.*;
import java.util.*;
public class ConnectionUtil {
  private static Connection connection;
  public static Connection getConnection() throws IOException, SQLException {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Properties prop = new Properties();
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    prop.load(loader.getResourceAsStream("connection.properties"));
    String url = prop.getProperty("url");
    String username = prop.getProperty("username"); 
    String password = prop.getProperty("password"); 
    if(connection == null || connection.isClosed()) {
      connection = DriverManager.getConnection(url, username, password);
    }
    return connection;
  }

}
