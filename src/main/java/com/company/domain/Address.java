package com.company.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ADDRESSES")
public abstract class Address extends AbstractEntity<Long> {
	
	@Column(name= "address", nullable = false)
	private String address;
	
	@Column(name= "complement")
	private String complement;
	
	@Column(name= "number", nullable = false, length = 5)
	private Integer number;
	
	@Column(name= "district", nullable = false)
	private String district;
	
	@Column(name= "city", nullable = false)
	private String city;
	
	@Column(name= "uf", nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private Uf uf;
	
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
