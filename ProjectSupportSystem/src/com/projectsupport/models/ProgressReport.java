package com.projectsupport.models;

public class ProgressReport {
	private String workCarried;
	private String problems;
	private String workPlannedButNotDone;
	private String workPlanned;
	private int mark;
	private int studentId;
	public String getWorkCarried() {
		return workCarried;
	}
	public void setWorkCarried(String workCarried) {
		this.workCarried = workCarried;
	}
	public String getProblems() {
		return problems;
	}
	public void setProblems(String problems) {
		this.problems = problems;
	}
	public String getWorkPlannedButNotDone() {
		return workPlannedButNotDone;
	}
	public void setWorkPlannedButNotDone(String workPlannedButNotDone) {
		this.workPlannedButNotDone = workPlannedButNotDone;
	}
	public String getWorkPlanned() {
		return workPlanned;
	}
	public void setWorkPlanned(String workPlanned) {
		this.workPlanned = workPlanned;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

}
