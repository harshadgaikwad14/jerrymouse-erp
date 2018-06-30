package com.erp.action.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.action.api.exception.ResourceNotFoundException;
import com.erp.action.api.model.Grade;
import com.erp.action.api.repository.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeRepository gradeRepository;

	@Override
	public Grade createGrade(Grade grade) {
		return gradeRepository.save(grade);
	}

	@Override
	public List<Grade> findAllGrades() {
		return (List<Grade>) gradeRepository.findAll();
	}

	@Override
	public Grade getGradeById(long gradeId) {
		return gradeRepository.findById(gradeId)
				.orElseThrow(() -> new ResourceNotFoundException("Grade", "id", gradeId));
	}

	@Override
	public Grade updateGrade(long gradeId, Grade grade) {
		Grade g = gradeRepository.findById(gradeId)
				.orElseThrow(() -> new ResourceNotFoundException("Grade", "id", gradeId));

		g.setGradeDesc(grade.getGradeDesc());
		g.setGradeName(grade.getGradeName());
		Grade updatedGrade = gradeRepository.save(g);

		return updatedGrade;
	}

	@Override
	public void deleteGrade(long gradeId) {
		Grade g = gradeRepository.findById(gradeId)
				.orElseThrow(() -> new ResourceNotFoundException("Grade", "id", gradeId));

		gradeRepository.delete(g);

	}

	@Override
	public void enableDisableGrade(long gradeId, boolean isActive) {
		// TODO Auto-generated method stub

	}

	
}
