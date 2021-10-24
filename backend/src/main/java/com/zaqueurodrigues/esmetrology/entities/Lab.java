package com.zaqueurodrigues.esmetrology.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_lab")
public class Lab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String accreditationNumber;
	@OneToMany(mappedBy = "lab")
	private Set<Certificate> certificates = new HashSet<>();
	
	public Lab() {
		
	}

	public Lab(Long id, String name, String address, String accreditationNumber, Set<Certificate> certificates) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.accreditationNumber = accreditationNumber;
		this.certificates = certificates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccreditationNumber() {
		return accreditationNumber;
	}

	public void setAccreditationNumber(String accreditationNumber) {
		this.accreditationNumber = accreditationNumber;
	}

	public Set<Certificate> getCertificates() {
		return certificates;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lab other = (Lab) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
