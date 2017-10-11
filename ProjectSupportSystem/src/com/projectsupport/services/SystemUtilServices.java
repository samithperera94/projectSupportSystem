package com.projectsupport.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.projectsupport.models.FormSub;



public class SystemUtilServices {
	public static void insertFormSubmissions(Connection conn, FormSub formdet) throws SQLException {
		String sql = "Insert into formSumissions (formType,endDate,endTime) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,formdet.getFormType());
		pstm.setString(2, formdet.getEndDate());
		pstm.setString(3, formdet.getEndTime());
		pstm.executeUpdate();
	}
	
	
	public static void deleteFormSubmission(Connection conn,String formType)throws SQLException {
		String sql = "Delete from formSumissions where formType=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, formType);
		pstm.executeUpdate();
	}
	public static List<FormSub> findFormSub(Connection conn) throws SQLException{
		String sql = "Select formType,endDate,endTime from formSumissions";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<FormSub> list = new ArrayList<FormSub>();
		while(rs.next()){
			String formtype = rs.getString("formType");
			String endDate = rs.getString("endDate");
			String endTime = rs.getString("endTime");
			FormSub formsub = new FormSub();
			formsub.setFormType(formtype);
			formsub.setEndDate(endDate);
			formsub.setEndTime(endTime);
			list.add(formsub);
		}
		return list;
	}
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
	Calendar cal = Calendar.getInstance();
	
}
