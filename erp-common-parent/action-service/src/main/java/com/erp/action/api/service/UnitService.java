package com.erp.action.api.service;

import java.util.List;

import com.erp.action.api.model.Unit;



public interface UnitService {
	
	public Unit createUnit( Unit unit);
	public List<Unit> findAllUnits();
	public Unit getUnitById(final long unitId);
	public Unit updateUnit(final long unitId,final Unit unit);
	public void deleteUnit(final long Unit);
	public void enableDisableUnit(final long unitId,final boolean isActive );

}
