package com.projectsupport.models;

public class Dissertation {
	private String formName;
	private int marks;
	private String supervisorComment;
	private int studentId;
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getSupervisorComment() {
		return supervisorComment;
	}
	public void setSupervisorComment(String supervisorComment) {
		this.supervisorComment = supervisorComment;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
}
