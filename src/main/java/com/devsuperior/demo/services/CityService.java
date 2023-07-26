package com.devsuperior.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repository.CityRepository;
import com.devsuperior.demo.services.exceptions.DataBaseException;
import com.devsuperior.demo.services.exceptions.ResourceNotFoundException;

@Service
public class CityService {

	@Autowired private CityRepository repository;
	
	public List<CityDTO> findAll() {
		
		final List<City> result = repository.findAll(Sort.by("name"));
		
		return result.stream().map(entity -> new CityDTO(entity)).toList();
	}

	public CityDTO insert(CityDTO dto) {

		City entity = new City(null, dto.getName());
		
		entity = repository.save(entity);
		
		return new CityDTO(entity);
	}

	public void delete(Long id) {
		
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException();
		}
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Falha de integridade referêncial");
		}
	}
}
