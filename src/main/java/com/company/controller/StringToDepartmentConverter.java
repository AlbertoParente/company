package com.company.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.company.models.Department;
import com.company.repository.DepartmentRepository;

@Component
public abstract class StringToDepartmentConverter implements Converter<String, Department> {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public Department convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return departmentRepository.findById(id);
	}

	

}
