package com.zaqueurodrigues.esmetrology.dtos;

import com.zaqueurodrigues.esmetrology.entities.Instrument;
import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstrumentViewDTO {
	
	private String tag;
	private String description;
	private String type;
	private String range;
	private String frequency;
	private InstrumentStatus status;
	private String note;
	private DepartmentViewDTO department;
	
	public static InstrumentViewDTO toInstrument(Instrument instrument) {
		return InstrumentViewDTO.builder()
				.tag(instrument.getTag())
				.description(instrument.getDescription())
				.type(instrument.getType())
				.range(instrument.getRange())
				.frequency(instrument.getFrequency())
				.status(instrument.getStatus())
				.note(instrument.getNote())
				.department(new DepartmentViewDTO(instrument.getDepartment().getName()))
				.build();
	}

}
