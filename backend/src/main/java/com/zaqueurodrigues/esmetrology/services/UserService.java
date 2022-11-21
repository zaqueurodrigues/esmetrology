package com.zaqueurodrigues.esmetrology.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zaqueurodrigues.esmetrology.dtos.UserSaveDTO;
import com.zaqueurodrigues.esmetrology.dtos.UserViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Department;
import com.zaqueurodrigues.esmetrology.entities.User;
import com.zaqueurodrigues.esmetrology.repositories.DepartmentRepository;
import com.zaqueurodrigues.esmetrology.repositories.UserRepository;
import com.zaqueurodrigues.esmetrology.services.exceptions.DatabaseException;
import com.zaqueurodrigues.esmetrology.services.exceptions.ResourceNotFoundException;


@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private AuthService authService;
	
	
	public Page<UserViewDTO> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(user -> new UserViewDTO(user));
	}
	
	public UserViewDTO findById(Long id) {
		authService.validateSelfOrAdmin(id);
		return repository.findById(id).map(user -> new UserViewDTO(user)).orElseThrow(() -> new ResourceNotFoundException("User not found"));
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
	
	public UserViewDTO insert(UserSaveDTO dto) {
		User user = parseDtoToUser(dto);
		
		Optional<Department> departmentOp = departmentRepository.findById(dto.getDepartment().getId());

		if (!departmentOp.isPresent()) {
			throw new ResourceNotFoundException("Department not exists: " + dto.getDepartment().getId());
		}

		user.setDepartment(departmentOp.get());

		user = repository.save(user);

		return new UserViewDTO(user);

	}

	public UserViewDTO update(Long id, UserSaveDTO dto) {
		dto.setId(id);
		Optional<Department> departmentOp = departmentRepository.findById(dto.getDepartment().getId());

		if (!departmentOp.isPresent()) {
			throw new ResourceNotFoundException("Incorrect department id!");
		}
		var department = departmentOp.get();

		var user = repository.getById(id);

		user = parseDtoToUser(dto);
		user.setDepartment(department);
		user = repository.save(user);
		return new UserViewDTO(user);

	}
	
	private User parseDtoToUser(UserSaveDTO dto) {
		
		return new User(
				dto.getId(),
				dto.getName(),
				dto.getEnrollment(),
				dto.getEmail(),
				passwordEncoder.encode(dto.getPassword()),
				null,
				dto.getRoles(),
				null
				);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);	
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found: " +id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

}
