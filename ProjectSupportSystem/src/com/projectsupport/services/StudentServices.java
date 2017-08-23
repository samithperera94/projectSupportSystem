package com.projectsupport.services;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.projectsupport.models.Student;



public class StudentServices {
	
		public static void insertStudent(Connection conn,Student student) throws SQLException {
			String sql = "Insert into Student(idStudent,firstName,lastName,email,address,mobileNo,DOB,gender) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,student.getStudentId() );
		    pstm.setString(2,student.getFirstName());
		    pstm.setString(3,student.getLastName());
		    pstm.setString(4,student.getEmail());
		    pstm.setString(5,student.getAddress());
		    pstm.setString(6,student.getMobileNo());
		    pstm.setString(7,student.getDob());
		    pstm.setString(8,student.getGender());
		    pstm.executeUpdate();
		}
		
	

}
