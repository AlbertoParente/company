package com.albertoparente.company.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.albertoparente.company.domain.Department;
import com.albertoparente.company.service.DepartmentService;

@Component
public class SpringToDepartmentConverter implements Converter<String, Department> {

	@Autowired
	private DepartmentService departmentService;
	
	@Override
	public Department convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return departmentService.findById(id);
	}
}
