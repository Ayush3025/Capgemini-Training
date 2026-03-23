package com.gal.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.gal.model.Training;
import com.gal.service.TrainingService;

//@SpringBootTest
@WebMvcTest(TrainingController.class)
class TrainingControllerTest {

	@MockitoBean
	TrainingService trainingService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void testFindById() throws Exception{
		Training t = new Training(101,Date.valueOf("2026-03-01"),Date.valueOf("2026-03-06"),"Mockito","Dinesh");
		when(trainingService.findById(101)).thenReturn(t);
		
		mockMvc.perform(get("/training/101")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.trainingId").value("101"))
			.andDo(res-> System.out.println(res.getResponse().getContentAsString()));
	}

}
