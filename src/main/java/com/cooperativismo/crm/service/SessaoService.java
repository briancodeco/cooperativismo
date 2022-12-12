package com.cooperativismo.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativismo.crm.model.Sessao;
import com.cooperativismo.crm.repository.SessaoRepository;

@Service
public class SessaoService {

	@Autowired
	SessaoRepository sessaoRepository;
	
	public Sessao cadastrar (Sessao sessao) {
		return sessaoRepository.save(sessao);
	}
	
	public List<Sessao> listar (){
		return sessaoRepository.findAll();
	}
	
	public Optional<Sessao> findById (long id){
		return sessaoRepository.findById(id);
	}

	public List<Sessao> getAll() {
		return sessaoRepository.findAll();
	}
}
