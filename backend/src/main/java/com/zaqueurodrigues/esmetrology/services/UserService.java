package com.zaqueurodrigues.esmetrology.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaqueurodrigues.esmetrology.dtos.UserDTO;
import com.zaqueurodrigues.esmetrology.entities.User;
import com.zaqueurodrigues.esmetrology.repositories.UserRepository;
import com.zaqueurodrigues.esmetrology.services.exceptions.ResourceNotFoundException;


@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		authService.validateSelfOrAdmin(id);
		return repository.findById(id).map(user -> new UserDTO(user)).orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if(user == null) {
			logger.error("User not found: " +username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found: " +username);
		return user;
	}

}
