package com.zaqueurodrigues.esmetrology.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstrumentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String tag;
	private String description;
	private String type;
	private String range;
	private String frequency;
	private Instant lastCalibration;
	private InstrumentStatus status;
	private String note;

}
