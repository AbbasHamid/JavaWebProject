package DAO;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.login;
import util.DBConnectionutil;

public class loginDAOimp implements loginDAO {

	@Override
	public String authenticate(login lg) {
	
		String sql = "SELECT * FROM tbl_login WHERE name=? and password=?";
		
		try {
			
			java.sql.Connection con =  DBConnectionutil.openconnection();
			 java.sql.PreparedStatement pr =  con.prepareStatement(sql);
			
			pr.setString(1, lg.getName());
			pr.setString(2, lg.getPassword());
			
			ResultSet rs = pr.executeQuery();
			
			if(rs.next()) {
				return "true";
			}else {
				return "false";
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return "Error";
		
		
	}

}
