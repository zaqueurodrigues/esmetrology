package com.zaqueurodrigues.esmetrology.dtos;

import com.zaqueurodrigues.esmetrology.entities.Lab;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LabViewDTO {

	private String name;
	private String address;
	private String accreditationNumber;
	
	public static LabViewDTO toLab(Lab lab) {
		return LabViewDTO.builder()
				.name(lab.getName())
				.address(lab.getAddress())
				.accreditationNumber(lab.getAccreditationNumber())
				.build();
	}

}
