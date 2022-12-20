package com.cooperativismo.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativismo.crm.model.Voto;
import com.cooperativismo.crm.repository.VotoRepository;

@Service
public class VotoService {
	
	@Autowired
	VotoRepository votoRepository;
	
	public Voto cadastrar (Voto voto) {
		return votoRepository.save(voto);
	}
	
	public Voto findByIdentificadorAndSessao_id(String identificador,long id) {
		return votoRepository.findByIdentificadorAndSessao_id(identificador,id);
	}
	
	public List<Voto> findBySessao_id(long id) {
		return votoRepository.findBySessao_id(id);
	}

	public List<Voto> findAll() {		
		return votoRepository.findAll();
	}

	public Optional<Voto> findById(long id) {		
		return votoRepository.findById(id);
	}
	
	

}
