package com.erp.action.api.service;

import java.util.List;

import com.erp.action.api.model.Grade;



public interface GradeService {
	
	public Grade createGrade( Grade grade);
	public List<Grade> findAllGrades();
	public Grade getGradeById(final long gradeId);
	public Grade updateGrade(final long gradeId,final Grade grade);
	public void deleteGrade(final long grade);
	public void enableDisableGrade(final long gradeId,final boolean isActive );

}
