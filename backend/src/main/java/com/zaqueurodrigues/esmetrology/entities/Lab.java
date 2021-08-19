package com.zaqueurodrigues.esmetrology.entities;

import java.io.Serializable;
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
public class Lab implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public Lab(Long id, String name, String address, String accreditationNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.accreditationNumber = accreditationNumber;
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

	public void setAccreditationNumber(String accreditaionNumber) {
		this.accreditationNumber = accreditaionNumber;
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
