package com.albertoparente.company.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "ADDRESSES")
public class Address extends AbstractEntity<Long> {
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(name= "address", nullable = false)
	private String address;
	
	@Column(name= "complement")
	private String complement;
	
	@NotNull(message = "{NotNull.address.number}")
	@Column(name= "number", nullable = false, length = 5)
	private Integer number;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(name= "district", nullable = false)
	private String district;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(name= "city", nullable = false)
	private String city;
	
	@NotNull(message = "{NotNull.address.uf}")
	@Column(name= "uf", nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private Uf uf;
	
	@NotBlank
	@Size(min = 9, max = 9,  message = "{Size.address.postalCode}")
	@Column(name= "postal_code", nullable = false, length = 9)
	private String postalCode;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
