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
		String sql = "select * from InterimReport where Student_idStudent=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, studentId);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){
			String formName = rs.getString("formName");
			float totalMarks = rs.getFloat("totalmarks");
			float title = rs.getFloat("titleM");
			float abstractM = rs.getFloat("abstractM");
			float intro = rs.getFloat("introductionM");
			float analysis = rs.getFloat("analysisM");
			float solution = rs.getFloat("solutionM");
			String supervisorComment = rs.getString("supervisorComments");
			String supervisorState = rs.getString("supervisorState");
			InterimReport interim = new InterimReport();
			interim.setTotalMarks(totalMarks);
			interim.setTitleM(title);
			interim.setAbstractM(abstractM);
			interim.setIntroductionM(intro);
			interim.setAnalysisM(analysis);
			interim.setSolutionM(solution);
			interim.setSupervisorComment(supervisorComment);
			interim.setSupervisorState(supervisorState);
			interim.setStudentId(studentId);
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
	
	public static void insertMarkInterimMarks(Connection conn,int studentId, float titleM,float abstractM,float introM,float analysisM,float solutionM,float totalM) throws SQLException {
		String sql = "update InterimReport set titleM=?,abstractM=?,introductionM=?,analysisM=?,solutionM=?,totalmarks=? where Student_idStudent=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setFloat(1,titleM);
		pstm.setFloat(2,abstractM);
		pstm.setFloat(3,introM);
		pstm.setFloat(4,analysisM);
		pstm.setFloat(5,solutionM);
		pstm.setFloat(6,totalM);
		pstm.setInt(7, studentId);
		pstm.executeUpdate();
		
	}	
	
	
	
}

