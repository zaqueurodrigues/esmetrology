package com.zaqueurodrigues.esmetrology.mappers;

import org.mapstruct.Mapper;

import com.zaqueurodrigues.esmetrology.dtos.DepartmentViewDTO;
import com.zaqueurodrigues.esmetrology.dtos.InstrumentSaveDTO;
import com.zaqueurodrigues.esmetrology.dtos.InstrumentViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Department;
import com.zaqueurodrigues.esmetrology.entities.Instrument;

@Mapper(componentModel = "spring")
public interface InstrumentMapper {
	
	InstrumentSaveDTO parseSaveDto(Instrument instrument);
	
	InstrumentViewDTO parseViewDto(Instrument instrument);
	
	Instrument parseInstrument(InstrumentSaveDTO instrumentSaveDTO);
	
	Instrument parseInstrument(InstrumentViewDTO instrumentViewDTO);
	
	DepartmentViewDTO parseViewDTO(Department department);
	
	Department parseDepartment(DepartmentViewDTO departmentViewDTO);

}
