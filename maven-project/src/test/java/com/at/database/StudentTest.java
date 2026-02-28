package com.at.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void testPrintAllStudent() {
		Student stu = new Student();
		try {
			stu.printAllStudent();
		} catch(Exception e) {
			e.printStackTrace();
			fail("exception "+e);
		}
		
	}

}
