package com.gal;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.gal.algo.Calc;
import com.gal.algo.MyCalc;
import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
public class MyBeanConfig {

	@Bean
	StringBuilder getStrigBuilder() {
		return new StringBuilder("bean from configuration");
	}
	
	@Bean
	@Primary
	Calc getCalc(){
		return new MyCalc();
	}
	
	@Bean(name = "CalcNamedBean")
	Calc getCalc2(){
		return new MyCalc();
	}
	
	DataSource mysqlDataSource() {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUrl("");
		ds.setUser(null);
		ds.setPassword(null);
	}
}
