package com.revature.interviewmanagement.entity;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.interviewmanagement.entity.credentials.EmployeeCredential;


@Entity 
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,unique=true,name="employee_id")
	private Long employeeId;
	
	@Column(nullable=false,unique=true,name="designation_id")
	private Long designationId;
	
	@Column(nullable=false,name="first_name")
	private String firstName;
	
	@Column(nullable=false,name="last_name")
	private String lastName;
	
	@Column(nullable=false,unique=true,name="phone_number")
	private String phoneNumber;
	
	@Column(nullable=false,unique=true,name="email_id")
	private String emailId;
	
	@Column(name="added_on")
	private LocalDateTime addedOn;
	
	@Column(name="updated_on")
	private LocalDateTime updatedOn;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee",cascade=CascadeType.ALL)
	private List<Interview> interview;
	
	
	@OneToOne
	@JoinColumn(nullable=false,name="credential_id")
	private EmployeeCredential employeeCredential;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDateTime getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(LocalDateTime addedOn) {
		this.addedOn = addedOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public List<Interview> getInterview() {
		return interview;
	}
	public void setInterview(List<Interview> interview) {
		this.interview = interview;
	}
	public EmployeeCredential getEmployeeCredential() {
		return employeeCredential;
	}
	public void setEmployeeCredential(EmployeeCredential employeeCredential) {
		this.employeeCredential = employeeCredential;
	}
	
	
	
	
	
	
}
