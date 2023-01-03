package com.gdu.app11.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDTO {

	// sql devleoper HR 계정 EMPLOYEES 테이블

	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String jobId;
	private int managerId;
	private Date hireDate;
	private double salary;
	private double commissionPct;
	private DeptDTO deptDTO; // DeptDTO에 있는걸 쓰기 위해서!
	
}
