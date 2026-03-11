package com.gal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gal.algo.Calc;
import com.gal.algo.PasswordHasher;

public class MainBeans {
	public static void main(String[] args) {
		
		// Method 1 of creating bean
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.gal");
		context.refresh();
		PasswordHasher bean = context.getBean(PasswordHasher.class);
		System.out.println(bean);
		System.out.println(bean.hash("Hello"));
		
		StringBuilder bean2 = context.getBean(StringBuilder.class);
		System.out.println(bean2);
		
		Calc bean3 = context.getBean(Calc.class);
		System.out.println(bean3.add(3, 5));
		
		String[] beans = context.getBeanDefinitionNames();
		
		for(String beanName:beans) {
			System.out.println(beanName);
		}
		
//		context.close();
	}

}
