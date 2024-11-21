package com.example.evaluacion1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evaluacion1.entity.Edificio;
import com.example.evaluacion1.repository.EdificioRepository;

@Service
public class EdificioService implements IEdificioService{
	
	@Autowired
	EdificioRepository edificioRepository;	
	
	@Override
	public List<Edificio> getAllEdificios() {
		return edificioRepository.findAll();
	}
	
	@Override
	public Optional<Edificio> findById(Long id)	{
		return edificioRepository.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		edificioRepository.deleteById(id);
	}
	
	@Override
	public Edificio save(Edificio edificio) {
		 return edificioRepository.save(edificio);
	}
	
}
