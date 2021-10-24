package com.zaqueurodrigues.esmetrology.mappers;

import org.mapstruct.Mapper;

import com.zaqueurodrigues.esmetrology.dtos.InstrumentSaveDTO;
import com.zaqueurodrigues.esmetrology.dtos.InstrumentViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Instrument;

@Mapper(componentModel = "spring")
public interface InstrumentMapper {
	
	
	InstrumentViewDTO parseViewDto(Instrument instrument);
	
	Instrument parseInstrument(InstrumentSaveDTO instrumentSaveDTO);
	
	Instrument parseInstrument(InstrumentViewDTO instrumentViewDTO);
	
	
}
