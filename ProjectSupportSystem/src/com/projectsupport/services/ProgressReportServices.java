package com.projectsupport.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projectsupport.models.ProgressReport;

public class ProgressReportServices {
	public static void insertProgressReport(Connection conn,ProgressReport pro) throws SQLException {
		String sql = "Insert into ProgressReports (workCarried,problems,workPlannedButNotDone,workPlanned,Student_idStudent) values (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,pro.getWorkCarried());
		pstm.setString(2,pro.getProblems());
		pstm.setString(3,pro.getWorkPlannedButNotDone());
		pstm.setString(4,pro.getWorkPlanned());
		pstm.setInt(5,pro.getStudentId());
		pstm.executeUpdate();
	}
	
	public static ProgressReport findProgressReport(Connection conn, int stundentID) throws SQLException {
		String sql1 = "select MAX(idProgressReports) from ProgressReports where Student_idStudent=?";
		PreparedStatement pstm1 = conn.prepareStatement(sql1);
		pstm1.setInt(1,stundentID);
		ResultSet rs1 = pstm1.executeQuery();
		if(rs1.next()){
			int latest = rs1.getInt(1);
			String sql2 = "select workCarried,problems,workPlannedButNotDone,workPlanned from ProgressReports where idProgressReports=?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, latest);
			
			ResultSet rs2 = pstm2.executeQuery();
			while(rs2.next()){
				String workCarried = rs2.getString("workCarried");
				String problems = rs2.getString("problems");
				String workPlannedButNotDone = rs2.getString("workPlannedButNotDone");
				String workPlanned = rs2.getString("workPlanned");
				//System.out.println(workPlanned);
				ProgressReport pro = new ProgressReport();
				pro.setWorkCarried(workCarried);
				pro.setProblems(problems);
				pro.setWorkPlannedButNotDone(workPlannedButNotDone);
				pro.setWorkPlanned(workPlanned);
				return pro;
			}
			
			}
		return null;
		}


	public static void editProgressReport(Connection conn, ProgressReport pro) throws SQLException {
		String sql1 = "select MAX(idProgressReports) from ProgressReports where Student_idStudent=?";
		PreparedStatement pstm1 = conn.prepareStatement(sql1);
		pstm1.setInt(1,pro.getStudentId());
		ResultSet rs1 = pstm1.executeQuery();
		if(rs1.next()){
			int latest = rs1.getInt(1);
			String sql2 = "Update ProgressReports set workCarried=?,problems=?,workPlannedButNotDone=?,workPlanned=? where idProgressReports=?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setString(1,pro.getWorkCarried());
			pstm2.setString(2,pro.getProblems());
			pstm2.setString(3,pro.getWorkPlannedButNotDone());
			pstm2.setString(4,pro.getWorkPlanned());
			pstm2.setInt(5,latest);
			pstm2.executeUpdate();
		}
			
			
	}
	
	public static void 	deleteProgressReport(Connection conn,int studentId) throws SQLException {
		String sql1 = "select MAX(idProgressReports) from ProgressReports where Student_idStudent=?";
		PreparedStatement pstm1 = conn.prepareStatement(sql1);
		pstm1.setInt(1,studentId);
		ResultSet rs1 = pstm1.executeQuery();
		if(rs1.next()){
			int latest = rs1.getInt(1);
			String sql2 = "Delete from ProgressReports where idProgressReports=?";
			PreparedStatement pstm = conn.prepareStatement(sql2);
			pstm.setInt(1, latest);
			pstm.executeUpdate();
		}
	}

}
