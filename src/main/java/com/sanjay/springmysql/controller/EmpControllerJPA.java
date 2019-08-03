package com.sanjay.springmysql.controller;

import com.sanjay.springmysql.daoJPA.Emp_Info;
import com.sanjay.springmysql.daoJPA.Emp_Service_JPA;
import com.sanjay.springmysql.daoJPA.Employees;
import com.sanjay.springmysql.errorHandling.ResourceNotFoundException;
import com.sanjay.springmysql.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
//@RequestMapping("/api/v1")
public class EmpControllerJPA {
	@Autowired
	private Emp_Service_JPA emp_service;
	@Autowired
	private EmpRepository empRepo;

	@RequestMapping(path = "/getAll", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Employees getAllEmp() {
		return emp_service.getAll();
	}


	@RequestMapping(path = "/getAll/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Emp_Info> getEmpDetails(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {

		Emp_Info employee = emp_service.getById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		return ResponseEntity.ok().body(employee);

	}

	@RequestMapping(path = "/getByName/{name}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Optional<List<Emp_Info>> getEmpDetails(@PathVariable String name) throws SQLException {
		return emp_service.getByName(name);
	}

	@RequestMapping(path = "/getByDeg/{deg}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Optional<List<Emp_Info>> getEmpDetailsByDeg(@PathVariable String deg) throws SQLException {
		return empRepo.findByEmpDeg(deg);
	}

	@RequestMapping(path = "/add-emp", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	/*
	 * @ModelAttribute is for multipart form data
	 */
	public String saveData(@ModelAttribute Emp_Info emp_info) throws SQLException {
		return emp_service.createNewEmp(emp_info);
	}

	/*
	 * @RequestBody is for Json body form data public String saveData(@RequestBody
	 * Emp_Info emp_info) throws SQLException { return
	 * emp_service.createNewEmp(emp_info); }
	 */
	@RequestMapping(path = "/delete-emp/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Boolean> deleteEMp(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		Emp_Info employee = emp_service.getById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		empRepo.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


	@PutMapping("/update-employee/{id}")
	public ResponseEntity<Emp_Info> updateEmployee(@PathVariable(value = "id") Integer employeeId,
			@Valid @RequestBody Emp_Info employeeDetails) throws ResourceNotFoundException {
		emp_service.getById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		final Emp_Info updatedEmployee = empRepo.save(employeeDetails);
		return ResponseEntity.ok(updatedEmployee);
	}

}
