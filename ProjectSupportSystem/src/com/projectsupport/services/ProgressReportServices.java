package com.projectsupport.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projectsupport.models.ProgressReport;
import com.projectsupport.models.ProgressReportSub;

public class ProgressReportServices {
	public static void insertProgressReport(Connection conn,ProgressReport pro) throws SQLException {
		String sql = "Insert into ProgressReports (reportNo,workCarried,describeTheWork,problems,workPlannedButNotDone,workPlanned,Student_idStudent) values (?,?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, pro.getReportNo());
		pstm.setString(2,pro.getWorkCarried());
		pstm.setString(3, pro.getDescribe());
		pstm.setString(4,pro.getProblems());
		pstm.setString(5,pro.getWorkPlannedButNotDone());
		pstm.setString(6,pro.getWorkPlanned());
		pstm.setInt(7,pro.getStudentId());
		pstm.executeUpdate();
	}
	
	public static ProgressReport findProgressReport(Connection conn, int stundentID) throws SQLException {
		String sql1 = "select MAX(idProgressReports) from ProgressReports where Student_idStudent=?";
		PreparedStatement pstm1 = conn.prepareStatement(sql1);
		pstm1.setInt(1,stundentID);
		ResultSet rs1 = pstm1.executeQuery();
		if(rs1.next()){
			int latest = rs1.getInt(1);
			String sql2 = "select reportNo,workCarried,describeTheWork,problems,workPlannedButNotDone,workPlanned from ProgressReports where idProgressReports=?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, latest);
			ResultSet rs2 = pstm2.executeQuery();
			while(rs2.next()){
				int reportNo = rs2.getInt("reportNo");
				String workCarried = rs2.getString("workCarried");
				String describe = rs2.getString("describeTheWork");
				String problems = rs2.getString("problems");
				String workPlannedButNotDone = rs2.getString("workPlannedButNotDone");
				String workPlanned = rs2.getString("workPlanned");
				//System.out.println(workPlanned);
				ProgressReport pro = new ProgressReport();
				pro.setReportNo(reportNo);
				pro.setWorkCarried(workCarried);
				pro.setDescribe(describe);
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
			String sql2 = "Update ProgressReports set workCarried=?,describeTheWork=?,problems=?,workPlannedButNotDone=?,workPlanned=? where idProgressReports=?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setString(1,pro.getWorkCarried());
			pstm2.setString(2, pro.getDescribe());
			pstm2.setString(3,pro.getProblems());
			pstm2.setString(4,pro.getWorkPlannedButNotDone());
			pstm2.setString(5,pro.getWorkPlanned());
			pstm2.setInt(6,latest);
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
	
	public static void insertProgressReportSub(Connection conn,ProgressReportSub det) throws SQLException {
		String sql = "Insert into progressReportDetails (progressNo,endDate,endTime) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,det.getReportNo());
		pstm.setString(2, det.getEndDate());
		pstm.setString(3,det.getEndTime());
		pstm.executeUpdate();
		
	}
	
	public static void deleteProgressReportSub(Connection conn,int reportNo) throws SQLException {
		String sql = "Delete from progressReportDetails where progressNo=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, reportNo);
		pstm.executeUpdate();
	}
	
	public static List<ProgressReportSub> findReportDetails(Connection conn) throws SQLException{
		String sql = "Select progressNo,endDate,endTime from progressReportDetails";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<ProgressReportSub> list = new ArrayList<ProgressReportSub>();
		while(rs.next()){
			int reportNo = rs.getInt("progressNo");
			String endDate = rs.getString("endDate");
			String endTime = rs.getString("endTime");
			ProgressReportSub reportDetails = new ProgressReportSub();
			reportDetails.setReportNo(reportNo);
			reportDetails.setEndDate(endDate);
			reportDetails.setEndTime(endTime);
			list.add(reportDetails);
		}
		return list;
	}
	
	public static ProgressReportSub findLatestReport(Connection conn) throws SQLException {
		String sql1 = "Select MAX(progressNo) from progressReportDetails";
		PreparedStatement pstm1 = conn.prepareStatement(sql1);
		ResultSet rs1 = pstm1.executeQuery();
		if(rs1.next()){
			int no = rs1.getInt(1);
			String sql2 = "select * from progressReportDetails where progressNo=?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1,no);
			ResultSet rs2 = pstm2.executeQuery();
			while(rs2.next()){
				int reportNo = rs2.getInt("progressNo");
				String endDate = rs2.getString("endDate");
				String endTime = rs2.getString("endTime");
				ProgressReportSub prsub = new ProgressReportSub();
				prsub.setReportNo(reportNo);
				prsub.setEndDate(endDate);
				prsub.setEndTime(endTime);
				return prsub;
			}
			
			
		}
		return null;
	}
	
	

}
