package com.zaqueurodrigues.esmetrology.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaqueurodrigues.esmetrology.entities.User;
import com.zaqueurodrigues.esmetrology.repositories.UserRepository;
import com.zaqueurodrigues.esmetrology.services.exceptions.ForbiddenException;
import com.zaqueurodrigues.esmetrology.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		} catch (Exception e) {
			throw new UnauthorizedException("Invalid user");
		}	
	}
	
	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();
		
		if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Access denied");
		}
	}
	
}
