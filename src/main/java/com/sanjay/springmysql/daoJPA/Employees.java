/**
 * 
 */
package com.sanjay.springmysql.daoJPA;

import java.util.List;

/**
 * @author GFFP7897
 *
 */
public class Employees {
	private List<Emp_Info> emp_InfoList;

	public List<Emp_Info> getEmp_Info() {
		return emp_InfoList;
	}

	public void setEmp_Info(List<Emp_Info> emp_InfoList) {
		this.emp_InfoList = emp_InfoList;
	}


}
