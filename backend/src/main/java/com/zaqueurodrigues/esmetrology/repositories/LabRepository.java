package com.zaqueurodrigues.esmetrology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaqueurodrigues.esmetrology.entities.Notification;

public interface LabRepository extends JpaRepository<Notification, Long>{

}
