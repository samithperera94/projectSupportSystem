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
		String sql = "select formName from FinalDissertation where Student_idStudent=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, studentId);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String formName = rs.getString("formName");
			Dissertation dissertation = new Dissertation();
			dissertation.setFormName(formName);
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
}
