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

import com.erp.action.api.model.Unit;
import com.erp.action.api.service.UnitService;

/**
 * Created by Harshad on 23/06/2018
 */
@RestController
@RequestMapping("/api")
public class UnitRestController {

	@Autowired
	UnitService unitService;

	@GetMapping("/units")
	public List<Unit> findAllUnits() {
		return unitService.findAllUnits();
	}

	@PostMapping("/units")
	public Unit createUnit(@RequestBody Unit unit) {

		return unitService.createUnit(unit);
	}

	@GetMapping("/units/{id}")
	public Unit getUnitById(@PathVariable(value = "id") Long unitId) {
		return unitService.getUnitById(unitId);
	}

	@PutMapping("/units/{id}")
	public Unit updateUnit(@PathVariable(value = "id") Long unitId, @Valid @RequestBody Unit unit) {

		return unitService.updateUnit(unitId, unit);
	}

	@DeleteMapping("/units/{id}")
	public ResponseEntity<?> deleteUnit(@PathVariable(value = "id") Long unitId) {
		unitService.deleteUnit(unitId);

		return ResponseEntity.ok().build();
	}
}
