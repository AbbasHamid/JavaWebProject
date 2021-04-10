package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import entity.Post;
import util.DBConnectionutil;

public class PostDAOimp implements PostDAO {

	Connection connection = null;
	Statement statement= null;
    ResultSet resultset = null;
	java.sql.PreparedStatement preparedstatment = null;
	
	//Function för att hämta alla posts från DB.
	@Override
	public List<Post> get() {
		
	
	 List<Post> list = null;
	 Post post = null;
	 
	 try {
		
		 list =  new ArrayList<Post>();
		 
		 String sql = "SELECT * FROM tbl_post ";
		 
		 connection = DBConnectionutil.openconnection();
		 
		// statement =  connection.createStatement();
		 if (connection != null) {
			 statement =  connection.createStatement();

		}else {
			System.out.println(" No connction");
		}
		 resultset = statement.executeQuery(sql);
		 
		 while (resultset.next()) {
		
			post =  new Post();
			
			post.setId(resultset.getInt("id"));
			post.setPost(resultset.getString("post"));
			post.setTag(resultset.getString("tag"));
			list.add(post);
		}
		 
		 
		 
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
		
		
	return list;	
		
		
		
	}


	//Function för att spara en post till DB
	@Override
	public boolean save(Post e) {
		
		boolean flag = false;
		
		try {
			
			String sql = "insert into tbl_post(post,  tag)values('" + e.getPost() + "', '"+e.getTag()+"')";
			connection = DBConnectionutil.openconnection();
			preparedstatment =  connection.prepareStatement(sql);
			preparedstatment.executeUpdate();
			flag = true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return flag;
		
		
	}


	//Function för att Hämta en specifik post för att kunna ändra på den
	@Override
	public Post get(int id) {
		
		
		Post post = null;
		
		try {
			post = new Post();
			String sql = "SELECT * FROM tbl_post WHERE id = "+ id;
			connection = DBConnectionutil.openconnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql);
			
			while (resultset.next()) {
				
				post.setId(resultset.getInt("id"));
				post.setTag(resultset.getString("tag"));
				post.setPost(resultset.getString("post"));
			}
			
		
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return post;
		
	}


	//Function för att ändra på en post
	@Override
	public boolean update(Post e) {
		
boolean flag = false;
		
		try {
			
			String sql = "UPDATE tbl_post SET post = '" + e.getPost() + "', tag = '" + e.getTag() + "' where id =" + e.getId();
			connection = DBConnectionutil.openconnection();
			preparedstatment =  connection.prepareStatement(sql);
			preparedstatment.executeUpdate();
			flag = true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return flag;
		
		
	}


	//Function för att ta bort en post
	@Override
	public void delete(int id) {
		
         try {
			
			String sql = "DELETE from tbl_post  where id =" + id;
			connection = DBConnectionutil.openconnection();
			preparedstatment =  connection.prepareStatement(sql);
			preparedstatment.executeUpdate();
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
