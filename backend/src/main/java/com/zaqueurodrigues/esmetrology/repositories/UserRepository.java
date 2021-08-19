package com.zaqueurodrigues.esmetrology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaqueurodrigues.esmetrology.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
