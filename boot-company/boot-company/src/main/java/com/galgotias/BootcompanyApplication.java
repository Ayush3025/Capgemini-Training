package com.galgotias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.galgotias.dao.DepartmentDao;
import com.galgotias.model.Department;
import com.galgotias.service.DepartmentService;
import com.galgotias.service.DepartmentServiceImplemt;


@SpringBootApplication
public class BootcompanyApplication {
	
	private final DepartmentServiceImplemt departmentServiceImplemt;
	
	

	public BootcompanyApplication(DepartmentServiceImplemt departmentServiceImplemt) {
		this.departmentServiceImplemt = departmentServiceImplemt;
	}



	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootcompanyApplication.class, args);
//		DepartmentDao dao = context.getBean(DepartmentDao.class);
//		Department department = dao.find(101);
		
		DepartmentService depService = context.getBean(DepartmentService.class);
		
//		depService.addDepartment(new Department(110,"Management"));
		
		depService.deleteDepartment(110);
		depService.findAll().forEach(System.out::println);
		
//		System.out.println(department);
	}
	

}
