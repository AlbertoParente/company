package com.albertoparente.company.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.albertoparente.company.domain.Office;
import com.albertoparente.company.service.OfficeService;

@Component
public class SpringToOfficeConverter implements Converter<String, Office>{

	@Autowired
	private OfficeService officeService;
	
	@Override
	public Office convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return officeService.findById(id);
	}
}
