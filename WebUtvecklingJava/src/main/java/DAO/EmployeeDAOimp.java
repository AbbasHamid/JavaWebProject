package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import entity.Employee;
import util.DBConnectionutil;

public class EmployeeDAOimp implements EmployeeDAO {

	Connection connection = null;
	Statement statement= null;
    ResultSet resultset = null;
	java.sql.PreparedStatement preparedstatment = null;
	
	
	@Override
	public List<Employee> get() {
		
	
	 List<Employee> list = null;
	 Employee employee = null;
	 
	 try {
		
		 list =  new ArrayList<Employee>();
		 
		 String sql = "SELECT * FROM tbl_employee ";
		 
		 connection = DBConnectionutil.openconnection();
		 
		// statement =  connection.createStatement();
		 if (connection != null) {
			 statement =  connection.createStatement();

		}else {
			System.out.println(" No connction");
		}
		 resultset = statement.executeQuery(sql);
		 
		 while (resultset.next()) {
		
			employee =  new Employee();
			
			employee.setId(resultset.getInt("id"));
			employee.setName(resultset.getString("name"));
			employee.setDob(resultset.getString("dob"));
			employee.setDepartement(resultset.getString("department"));
			list.add(employee);
		}
		 
		 
		 
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
		
		
	return list;	
		
		
		
	}



	@Override
	public boolean save(Employee e) {
		
		boolean flag = false;
		
		try {
			
			String sql = "insert into tbl_employee(name, dob, department)values('" + e.getName() + "', '" + e.getDob()+ "', '"+e.getDepartement()+"')";
			connection = DBConnectionutil.openconnection();
			preparedstatment =  connection.prepareStatement(sql);
			preparedstatment.executeUpdate();
			flag = true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return flag;
		
		
	}



	@Override
	public Employee get(int id) {
		
		Employee employee = null;
		
		try {
			employee = new Employee();
			String sql = "SELECT * FROM tbl_employee WHERE id = "+ id;
			connection = DBConnectionutil.openconnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql);
			
			while (resultset.next()) {
				
				employee.setId(resultset.getInt("id"));
				employee.setDob(resultset.getString("dob"));
				employee.setDepartement(resultset.getString("department"));
				employee.setName(resultset.getString("name"));
			}
			
		
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return employee;
		
	}



	@Override
	public boolean update(Employee e) {
		
boolean flag = false;
		
		try {
			
			String sql = "UPDATE tbl_employee SET name = '" + e.getName()+"', dob = '"+ e.getDob() + "', department = '" + e.getDepartement() + "' where id =" + e.getId();
			connection = DBConnectionutil.openconnection();
			preparedstatment =  connection.prepareStatement(sql);
			preparedstatment.executeUpdate();
			flag = true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return flag;
		
		
	}



	@Override
	public void delete(int id) {
		
         try {
			
			String sql = "DELETE from tbl_employee  where id =" + id;
			connection = DBConnectionutil.openconnection();
			preparedstatment =  connection.prepareStatement(sql);
			preparedstatment.executeUpdate();
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
