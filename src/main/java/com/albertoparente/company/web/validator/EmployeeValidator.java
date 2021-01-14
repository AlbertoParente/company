package com.albertoparente.company.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.albertoparente.company.domain.Employee;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Employee e = (Employee) object;
		LocalDate admissionDate = e.getAdmissionDate();
		
		if(e.getResignationDate() != null) {
			if(e.getResignationDate().isBefore(admissionDate)) {
				errors.rejectValue("resignationDate", "BeforeAdmissionDate.employee.resignationDate");
			}
		}
	}

}
