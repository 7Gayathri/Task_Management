package com.example.task.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "status")
	private String status;
	
	@Column(name = "assignee")
	private String assignee;
	
	@Column(name = "reporting")
	private String reporting;
	
	@Column(name = "estimatetime")
	private String estimatetime;
	
	@Column(name = "spenttime")
	private String spenttime;
	
	@Column(name = "tdate")
	private String tdate;

	public Tasks() {
		super();
	}

	public Tasks(String name, String description,String status,String assignee,String reporting,String estimatetime,String spenttime,String tdate) {
		super();

	   this.name = name;
		this.description =description;
		this.assignee=assignee;
		this.tdate=tdate;
		this.estimatetime=estimatetime;
		this.status=status;
		this.reporting=reporting;
		this.spenttime=spenttime;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getReporting() {
		return reporting;
	}

	public void setReporting(String reporting) {
		this.reporting = reporting;
	}

	public String getEstimatetime() {
		return estimatetime;
	}

	public void setEstimatetime(String estimatetime) {
		this.estimatetime = estimatetime;
	}

	public String getSpenttime() {
		return spenttime;
	}

	public void setSpenttime(String spenttime) {
		this.spenttime = spenttime;
	}

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}



		

}
