package com.projectsupport.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import com.projectsupport.models.User;



public class UserServices {
	
	public static User findUser(Connection conn,String userName,String password) throws SQLException{
		String sql = "Select userName,password,position from User where userName=? and password=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()){
			String pos = rs.getString("position");
			User loginUser = new User();
			loginUser.setUserName(userName);
			loginUser.setPassword(password);
			loginUser.setPosition(pos);
			return loginUser;
		}
		return null;
	}
	
	
	  public static User findUser(Connection conn, String userName) throws SQLException {
		  String sql = "Select userName, password, position from User where userName =?";
		  PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, userName);
	      ResultSet rs = pstm.executeQuery();
	      if (rs.next()) {
	          String password = rs.getString("Password");
	          String position = rs.getString("position");
	          User loginUser = new User();
	          loginUser.setUserName(userName);
	          loginUser.setPassword(password);
	          loginUser.setPosition(position);
	          return loginUser;
	      }
	      return null;
	  }

}
