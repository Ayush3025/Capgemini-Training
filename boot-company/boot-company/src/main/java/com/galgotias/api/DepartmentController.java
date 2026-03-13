package com.galgotias.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galgotias.model.Department;
import com.galgotias.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentService depService;
	
	@RequestMapping("/department")
	@ResponseBody
	public String getDepartment() {
		Department department = depService.find(102);
		return department.toString();
	}

}
