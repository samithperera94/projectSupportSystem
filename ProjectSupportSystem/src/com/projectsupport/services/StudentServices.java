package com.projectsupport.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.projectsupport.models.Student;



public class StudentServices {
	
		public static List<Student> getStudentList(Connection conn) throws SQLException {
			String sql = "select idStudent,NIC,FullName,Initial,SurName,Email,TelephoneNo from Student";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			List<Student> list = new ArrayList<Student>();
			while(rs.next()){
				int studentId = rs.getInt("idStudent");
				String nic = rs.getString("NIC");
				String fullName = rs.getString("FullName");
				String initial = rs.getString("Initial");
				String surName = rs.getString("SurName");
				String email = rs.getString("Email");
				String telephoneNo = rs.getString("TelephoneNo");
				Student student = new Student();
				student.setStudentId(studentId);
				student.setNic(nic);
				student.setFullName(fullName);
				student.setInitial(initial);
				student.setSurName(surName);
				student.setEmail(email);
				student.setTelephoneNo(telephoneNo);
				list.add(student);
				
			}
			return list;
			
		}
		
	

}
