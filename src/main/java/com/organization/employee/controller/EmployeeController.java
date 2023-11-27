package com.organization.employee.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.organization.employee.model.Employee;
import com.organization.employee.service.EmployeeService;

@RestController
@RequestMapping(value="v1/organization/{organizationId}/empId")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/{empId}",method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee( @PathVariable("organizationId") String organizationId,
			@PathVariable("empId") String empId) {
		
		Employee employee = employeeService.getEmployee(empId, organizationId);
		employee.add( 
				linkTo(methodOn(EmployeeController.class).getEmployee(organizationId, employee.getEmpId())).withSelfRel(),
				linkTo(methodOn(EmployeeController.class).addEmployee(organizationId, employee, null)).withRel("addEmployee"),
				linkTo(methodOn(EmployeeController.class).updateEmployee(organizationId, employee)).withRel("updateEmployee"),
				linkTo(methodOn(EmployeeController.class).deleteEmployee(organizationId, employee.getEmpId())).withRel("deleteEmployee")
		);
		
		return ResponseEntity.ok(employee);
	}

	@PutMapping
	public ResponseEntity<String> updateEmployee(@PathVariable("organizationId") String organizationId, @RequestBody Employee request) {
		return ResponseEntity.ok(employeeService.updateEmployee(request, organizationId));
	}

	@PostMapping
	public ResponseEntity<String> addEmployee(@PathVariable("organizationId") String organizationId, @RequestBody Employee request,
			@RequestHeader(value = "Accept-Language",required = false) Locale locale) {
		return ResponseEntity.ok(employeeService.addEmployee(request, organizationId, locale));
	}

	@DeleteMapping(value="/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("organizationId") String organizationId, @PathVariable("empId") String empId) {
		return ResponseEntity.ok(employeeService.deleteEmployee(empId, organizationId));
	}
}
