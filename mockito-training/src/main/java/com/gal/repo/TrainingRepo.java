package com.gal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gal.model.Training;

@Repository
public interface TrainingRepo extends JpaRepository<Training, Integer>{
	
}
