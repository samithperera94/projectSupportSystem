package com.projectsupport.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projectsupport.models.Client;


public class ClientServices {
	public static void insertClient(Connection conn, Client client) throws SQLException {
		String sql = "Insert into Client (name,registrationNo,addressLine1,addressLine2,addressLine3,email,telephoneNo,formName,Student_idStudent) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,client. getOrganizationName());
		pstm.setString(2, client.getRegistrationNo());
		pstm.setString(3,client.getAddressLine1());
		pstm.setString(4,client.getAddressLine2());
		pstm.setString(5,client.getAddressLine3());
		pstm.setString(6, client.getOrganizationEmail());
		pstm.setString(7, client.getTelephoneNo());
		pstm.setString(8,client.getFormName());
		pstm.setInt(9,client.getStudentId());
		pstm.executeUpdate();
		
		
	}
	
	public static Client findClient(Connection conn,int userId) throws SQLException {
		String sql = "Select name,registrationNo,addressLine1,addressLine2,addressLine3,email,telephoneNo,formName from Client where Student_idStudent= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){
			String name = rs.getString("name");
			String registrationNo = rs.getString("registrationNo");
			String addressLine1 = rs.getString("addressLine1");
			String addressLine2 = rs.getString("addressLine2");
			String addressLine3 = rs.getString("addressLine3");
			String email = rs.getString("email");
			String telephoneNo = rs.getString("telephoneNo");
			String formName = rs.getString("formName");
			Client client = new Client();
			client.setOrganizationName(name);;
			client.setRegistrationNo(registrationNo);
			client.setAddressLine1(addressLine1);
			client.setAddressLine2(addressLine2);
			client.setAddressLine3(addressLine3);
			client.setOrganizationEmail(email);
			client.setTelephoneNo(telephoneNo);
			client.setFormName(formName);
			return client;
			
		}
		return null;
	}
	
	public static void editClient(Connection conn,Client client) throws SQLException {
		String sql = "update Client set name=?,registrationNo=?,addressLine1=?,addressLine2=?,addressLine3=?,email=?,telephoneNo=?,formName=? where Student_idStudent";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, client.getOrganizationName());
		pstm.setString(2, client.getRegistrationNo());
		pstm.setString(3, client.getAddressLine1());
		pstm.setString(4, client.getAddressLine2());
		pstm.setString(5, client.getAddressLine3());
		pstm.setString(6, client.getOrganizationEmail());
		pstm.setString(7, client.getTelephoneNo());
		pstm.setString(8, client.getFormName());
		pstm.executeUpdate();
	}
	
	public static void deleteClient(Connection conn, int userId) throws SQLException {
		String sql = "Delete from Client where Student_idStudent=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		pstm.executeUpdate();
	}

}
