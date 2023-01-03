package com.gdu.app11.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptDTO {

	// sql devleoper HR 계정 DEPARMENTS 테이블
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	
	
}
