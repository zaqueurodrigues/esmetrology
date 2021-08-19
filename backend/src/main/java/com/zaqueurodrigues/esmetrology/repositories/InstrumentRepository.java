package com.zaqueurodrigues.esmetrology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaqueurodrigues.esmetrology.entities.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long>{

}
