package com.sanjay.springmysql.daoJPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_info")
public class Emp_Info {
	@Id
	@Column(name = "empId",nullable = false)
	private Integer empId;
	@Column(name = "empName",nullable = false)
	private String empName;
	@Column(name = "empDeg",nullable = false)
	private String empDeg;
	@Column(name = "empDept",nullable = false)
	private String empDept;

	public Emp_Info() {
		super();
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDeg() {
		return empDeg;
	}

	public void setEmpDeg(String empDeg) {
		this.empDeg = empDeg;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	@Override
	public String toString() {
		return "Emp_Info [empId=" + empId + ", empName=" + empName + ", empDeg=" + empDeg + ", empDept=" + empDept
				+ "]";
	}

}
