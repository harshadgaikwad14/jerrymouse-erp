package com.erp.action.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.action.api.exception.ResourceNotFoundException;
import com.erp.action.api.model.Unit;
import com.erp.action.api.repository.UnitRepository;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitRepository unitRepository;

	@Override
	public Unit createUnit(Unit unit) {
		return unitRepository.save(unit);
	}

	@Override
	public List<Unit> findAllUnits() {
		return (List<Unit>) unitRepository.findAll();
	}

	@Override
	public Unit getUnitById(long unitId) {
		return unitRepository.findById(unitId)
				.orElseThrow(() -> new ResourceNotFoundException("Unit", "id", unitId));
	}

	@Override
	public Unit updateUnit(long unitId, Unit unit) {
		Unit u = unitRepository.findById(unitId)
				.orElseThrow(() -> new ResourceNotFoundException("Unit", "id", unitId));

		u.setUnitDesc(unit.getUnitDesc());
		u.setUnitName(unit.getUnitName());
		Unit updatedUnit = unitRepository.save(u);

		return updatedUnit;
	}

	@Override
	public void deleteUnit(long unitId) {
		Unit u = unitRepository.findById(unitId)
				.orElseThrow(() -> new ResourceNotFoundException("Unit", "id", unitId));

		unitRepository.delete(u);

	}

	@Override
	public void enableDisableUnit(long unitId, boolean isActive) {
		// TODO Auto-generated method stub

	}

	
}
