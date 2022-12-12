package com.cooperativismo.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cooperativismo.crm.model.Pauta;
import com.cooperativismo.crm.repository.PautaRepository;

@Service
public class PautaService {
	@Autowired
	PautaRepository pautaRepository;	

	public List<Pauta> getAll() {
		return pautaRepository.findAll();		
	}
	
	public Pauta cadastrar (Pauta pauta) {
		return pautaRepository.save(pauta);
	}

	public Optional<Pauta> findById(long id) {		
		return pautaRepository.findById(id);
	}
	
}
