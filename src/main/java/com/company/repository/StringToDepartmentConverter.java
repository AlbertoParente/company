package com.company.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.company.models.Department;

@Component
public class StringToDepartmentConverter implements Converter<String, Department> {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return departmentRepository.findById(id);
	}

	

}