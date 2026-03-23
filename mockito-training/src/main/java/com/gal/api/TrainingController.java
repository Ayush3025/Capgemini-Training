package com.gal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gal.model.Training;
import com.gal.service.TrainingService;

@RestController
@RequestMapping("/training")
public class TrainingController {
	private TrainingService trainingService;

	@Autowired
	public TrainingController(TrainingService trainingService) {
		super();
		this.trainingService = trainingService;
	}
	
	@GetMapping("/{trainingId}")
	Training findById(@PathVariable int trainingId) {
		Training training = trainingService.findById(trainingId);
		return training;
	}
	
}
