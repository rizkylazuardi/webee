package com.anabatic.webee.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anabatic.pmo.persistence.entity.EmployeeGroup;
import com.anabatic.pmo.service.api.EmployeeGroupService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired 
	private EmployeeGroupService groupService;
	
	@RequestMapping(value = "getAllGroup", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<List<EmployeeGroup>> getAllEmployeeGroup() {
		List<EmployeeGroup> response = groupService.findAll(new EmployeeGroup());
		
		return new ResponseEntity<List<EmployeeGroup>>(response, HttpStatus.OK);
	}
}
