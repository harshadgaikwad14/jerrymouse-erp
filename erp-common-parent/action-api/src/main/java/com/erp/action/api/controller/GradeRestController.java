package com.erp.action.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.action.api.model.Grade;
import com.erp.action.api.service.GradeService;

/**
 * Created by Harshad on 23/06/2018
 */
@RestController
@RequestMapping("/api")
public class GradeRestController {

	@Autowired
	GradeService gradeService;

	@GetMapping("/grades")
	public List<Grade> findAllGrades() {
		return gradeService.findAllGrades();
	}

	@PostMapping("/grades")
	public Grade createGrade(@RequestBody Grade grade) {

		return gradeService.createGrade(grade);
	}

	@GetMapping("/grades/{id}")
	public Grade getGradeById(@PathVariable(value = "id") Long gradeId) {
		return gradeService.getGradeById(gradeId);
	}

	@PutMapping("/grades/{id}")
	public Grade updateGrade(@PathVariable(value = "id") Long gradeId, @Valid @RequestBody Grade grade) {

		return gradeService.updateGrade(gradeId, grade);
	}

	@DeleteMapping("/grades/{id}")
	public ResponseEntity<?> deleteGrade(@PathVariable(value = "id") Long gradeId) {
		gradeService.deleteGrade(gradeId);

		return ResponseEntity.ok().build();
	}
}
