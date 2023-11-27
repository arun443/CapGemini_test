package com.organization.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.employee.service.EmployeeService;

@RestController
@RequestMapping(value="")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

}
