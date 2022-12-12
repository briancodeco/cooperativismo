package com.cooperativismo.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cooperativismo.crm.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {	
	
	Voto findByIdentificadorAndSessao_id(String identificador,long id);
	List<Voto> findBySessao_id(long id);
}
