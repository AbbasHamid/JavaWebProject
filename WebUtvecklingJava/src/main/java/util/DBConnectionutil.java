package util;
import java.sql.*;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import entity.Employee;


import com.microsoft.sqlserver.jdbc.SQLServerDriver;


public class DBConnectionutil {
	
	
	
	  private static final String UserName = "abbass"; 
	  private static final String password = "Password123"; 
	  private static final String URL = "jdbc:sqlserver://localhost;database=employeedirectory;";
	  
	  
	  private static Connection connection = null;
	  public static Connection openconnection() {
	  
	  if(connection != null) { 
		  
		  return connection; 
		  
	  }else {
	  
	  
	  try {
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	      connection = (Connection) DriverManager.getConnection(URL,UserName,password
	  );
	  
	  
	  } catch (Exception e) { e.printStackTrace(); }
	  
	  
	  return connection;
	  
	  
	  
	  } }
	  
	 
	 
	   
	
     
	
	
	
	
	
	

}
