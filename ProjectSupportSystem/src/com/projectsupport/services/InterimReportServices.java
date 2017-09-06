package com.projectsupport.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projectsupport.models.InterimReport;

public class InterimReportServices {
	public static void insertInterimReport(Connection conn,InterimReport interim) throws SQLException{
		String sql = "Insert into InterimReport (formName,Student_idStudent) values (?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,interim.getFormName());
		pstm.setInt(2,interim.getStudentId());
		pstm.executeUpdate();
	}
	
	
	
	public static InterimReport findInterimReport(Connection conn,int studentId) throws SQLException {
		String sql = "select formName from InterimReport where Student_idStudent=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, studentId);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){
			String formName = rs.getString("formName");
			InterimReport interim = new InterimReport();
			interim.setFormName(formName);
			return interim;
		}
		return null;
	}
	
	
	public static void editInterimReport(Connection conn,InterimReport interim) throws SQLException {
		String sql = "update InterimReport set formName=? where Student_idStudent=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, interim.getFormName());
		pstm.setInt(1, interim.getStudentId());
		pstm.executeUpdate();
	}	
	
	
	public static void deleteInterimReport(Connection conn, int studentId) throws SQLException {
		String sql = "Delete from InterimReport where Student_idStudent=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, studentId);
		pstm.executeUpdate();
	}
	
}

