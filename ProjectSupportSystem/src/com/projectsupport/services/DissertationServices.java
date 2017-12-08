package com.projectsupport.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projectsupport.models.Dissertation;


public class DissertationServices {
	public static void insertDissertation(Connection conn, Dissertation dissertation) throws SQLException {
		String sql = "Insert into FinalDissertation (formName,Student_idStudent) values (?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, dissertation.getFormName());
		pstm.setInt(2, dissertation.getStudentId());
		pstm.executeUpdate();
	}

	public static Dissertation findDissertation(Connection conn, int studentId) throws SQLException {
		String sql = "select * from FinalDissertation where Student_idStudent=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, studentId);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String supervisorComment = rs.getString("supervisorComment");
			String supervisorState = rs.getString("SupervisorState");
			float introduction = rs.getFloat("introduction");
			float analysis= rs.getFloat("analysis");
			float design = rs.getFloat("design");
			float implementation = rs.getFloat("implementation");
			float evaluation = rs.getFloat("evaluation");
			float conclusion = rs.getFloat("conclustion");
			float reference = rs.getFloat("reference");
			float appendices = rs.getFloat("appendices");
			float general = rs.getFloat("general");
			float total = rs.getFloat("total");
			String formName = rs.getString("formName");
			Dissertation dissertation = new Dissertation();
			dissertation.setFormName(formName);
			dissertation.setSupervisorComment(supervisorComment);
			dissertation.setSupervisorState(supervisorState);
			dissertation.setIntroduction(introduction);
			dissertation.setAnalysis(analysis);
			dissertation.setDesign(design);
			dissertation.setImplementation(implementation);
			dissertation.setEvaluation(evaluation);
			dissertation.setConclusion(conclusion);
			dissertation.setReference(reference);
			dissertation.setAppendices(appendices);
			dissertation.setGeneral(general);
			dissertation.setTotal(total);
			return dissertation;
		}
		return null;
	}

	public static void editDissertation(Connection conn, Dissertation dissertation) throws SQLException {
		String sql = "update FinalDissertation set formName=? where Student_idStudent=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,dissertation.getFormName());
		pstm.setInt(1, dissertation.getStudentId());
		pstm.executeUpdate();
	}

	public static void deleteDissertation(Connection conn, int studentId) throws SQLException {
		String sql = "Delete from FinalDissertation where Student_idStudent=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, studentId);
		pstm.executeUpdate();
	}
	
	public static void insertDissertationMark(Connection conn,int studentId,float introduction,float analysis,float design,float implementation,float evaluation,float conclusion,float reference,float appendices,float general,float total) throws SQLException{
		String sql="update InterimReport set introduction=?,analysis=?,design=?,implementation=?,evaluation=?,conclustion=?,references=?,appendices=?,general=?,totalmark=? where Student_idStudent=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setFloat(1,introduction);
		pstm.setFloat(2,analysis);
		pstm.setFloat(3,design);
		pstm.setFloat(4,implementation);
		pstm.setFloat(5,evaluation);
		pstm.setFloat(6,conclusion);
		pstm.setFloat(7,reference);
		pstm.setFloat(8,appendices);
		pstm.setFloat(9,general);
		pstm.setFloat(10,total);
		pstm.setInt(11,studentId);
		pstm.executeUpdate();
	}
}
