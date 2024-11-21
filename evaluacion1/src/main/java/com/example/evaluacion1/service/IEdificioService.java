package com.example.evaluacion1.service;

import java.util.List;
import java.util.Optional;
import com.example.evaluacion1.entity.Edificio;

public interface IEdificioService {
	public List<Edificio> getAllEdificios();	
	public Optional<Edificio> findById(Long id);	
	public void deleteById(Long id);
	Edificio save(Edificio edificio);
}
