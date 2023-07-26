package com.devsuperior.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repository.CityRepository;

@Service
public class CityService {

	@Autowired private CityRepository repository;
	
	public List<CityDTO> findAll() {
		
		final List<City> result = repository.findAll(Sort.by("name"));
		
		return result.stream().map(entity -> new CityDTO(entity)).toList();
	}
}
