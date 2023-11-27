package com.organization.employee.service;

import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.organization.employee.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	MessageSource messages;

	public Employee getEmployee(String empId, String organizationId){
		Employee employee = new Employee();
		employee.setEmpId(String.valueOf(new Random().nextInt(1000)));		
		employee.setEmpFirstName("David"); 
		employee.setEmpLastName("Johnson");
		employee.setOranizationID("JPMC");
		
		return employee;
	}

	public String addEmployee(Employee employee, String organizationId, Locale locale){
		String responseMessage = null;
		if(!StringUtils.isEmpty(employee)) {
			employee.setOranizationID(organizationId);
			employee.setEmpFirstName(employee.getEmpFirstName());
			employee.setEmpLastName(employee.getEmpLastName());
			responseMessage = String.format(messages.getMessage("emp.create.message",null,locale), employee.toString());
		}

		return responseMessage;
	}

	public String updateEmployee(Employee employee, String location){
		String responseMessage = null;
		if(!StringUtils.isEmpty(employee)) {
			employee.getLocation();
			responseMessage = String.format(messages.getMessage("emp.update.message", null, null), employee.toString());
		}

		return responseMessage;
	}

	public String deleteEmployee(String organizationId,String empId ){
		String responseMessage = null;
		responseMessage = String.format(messages.getMessage("emp.delete.message", null, null),empId, organizationId);
		return responseMessage;

	}
}
