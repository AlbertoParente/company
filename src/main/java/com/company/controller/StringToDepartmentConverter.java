package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.company.models.Department;
import com.company.repository.DepartmentRepository;

@Component
public class StringToDepartmentConverter implements Converter<String, Department> {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		//long id = Long.parseLong(text);
		Long id = Long.valueOf(text);
		System.out.println(text);
		return departmentRepository.findAllById(id);
		
	}
}