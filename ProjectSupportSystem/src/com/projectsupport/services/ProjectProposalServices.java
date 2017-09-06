package com.projectsupport.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projectsupport.models.ProjectProposal;

public class ProjectProposalServices {
	
	public static void insertProjectProposal(Connection conn,ProjectProposal proposal) throws SQLException {
		String sql = "insert into ProjectProposal (projectTitle,noOfAttempts,previousDecision,earlierProjectTitle,motivationForTheProject,objectives,scope,functionalities,deliverables,resources,selfEvaluation,Student_idStudent) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,proposal.getProjectTitle());
		pstm.setInt(2,proposal.getNoOfAttempts());
		pstm.setString(3,proposal.getPreviousDecision());
		pstm.setString(4,proposal.getEarlierProjectTitle());
		pstm.setString(5,proposal.getMotivation());
		pstm.setString(6,proposal.getObjectives());
		pstm.setString(7,proposal.getScope());
		pstm.setString(8,proposal.getFunctionalities());
		pstm.setString(9,proposal.getDeliverables());
		pstm.setString(10,proposal.getResources());
		pstm.setString(11,proposal.getEvaluation());
		pstm.setInt(12,proposal.getStudentId());
		pstm.executeUpdate();
	}
	
	public static ProjectProposal findProjectProposal(Connection conn,int userId) throws SQLException {
		String sql = "select projectTitle,noOfAttempts,previousDecision,earlierProjectTitle,motivationForTheProject,objectives,scope,functionalities,deliverables,resources,selfEvaluation from ProjectProposal where Student_idStudent=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){
			String projectTitle = rs.getString("projectTitle");
			int noOfAttempts = rs.getInt("noOfAttempts");
			String previousDecision = rs.getString("previousDecision");
			String earlierProjectTitle = rs.getString("earlierProjectTitle");
			String motivationForTheProject = rs.getString("motivationForTheProject");
			String objectives = rs.getString("objectives");
			String scope = rs.getString("scope");
			String functionalities = rs.getString("functionalities");
			String deliverables =  rs.getString("deliverables");
			String resources = rs.getString("resources");
			String selfEvaluation = rs.getString("selfEvaluation");
			ProjectProposal proposal =  new ProjectProposal();
			proposal.setProjectTitle(projectTitle);
			proposal.setNoOfAttempts(noOfAttempts);
			proposal.setPreviousDecision(previousDecision);
			proposal.setEarlierProjectTitle(earlierProjectTitle);
			proposal.setMotivation(motivationForTheProject);
			proposal.setObjectives(objectives);
			proposal.setScope(scope);
			proposal.setFunctionalities(functionalities);
			proposal.setDeliverables(deliverables);
			proposal.setResources(resources);
			proposal.setEvaluation(selfEvaluation);
			return proposal;
		}
		return null;

	}
	public static void editProjectProposal(Connection conn,ProjectProposal proposal) throws SQLException {
		String sql = "update ProjectProposal set projectTitle=?,noOfAttempts=?,previousDecision=?,earlierProjectTitle=?,motivationForTheProject=?,objectives=?,scope=?,functionalities=?,deliverables=?,resources=?,selfEvaluation=? where Student_idStudent=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, proposal.getProjectTitle());
		pstm.setInt(2, proposal.getNoOfAttempts());
		pstm.setString(3, proposal.getPreviousDecision());
		pstm.setString(4, proposal.getEarlierProjectTitle());
		pstm.setString(5, proposal.getMotivation());
		pstm.setString(6, proposal.getObjectives());
		pstm.setString(7, proposal.getScope());
		pstm.setString(8, proposal.getFunctionalities());
		pstm.setString(9, proposal.getDeliverables());
		pstm.setString(10, proposal.getResources());
		pstm.setString(11, proposal.getEvaluation());
		pstm.setInt(12, proposal.getStudentId());
		pstm.executeUpdate();
		
	}
	
	public static void deleteProgressReport(Connection conn,int StudentId) throws SQLException {
		String sql = "Delete from ProjectProposal where Student_idStudent=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, StudentId);
		pstm.executeUpdate();
	}

}
