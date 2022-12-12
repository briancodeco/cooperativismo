package com.cooperativismo.crm.model;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;




@Entity
@Table
public class Pauta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	private String descricao;
	@Column(name="data_cadastro")
	private Calendar dataCadastro;	
	@Transient
	private List<String> votos;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public List<String> getVotos() {
		return votos;
	}
	public void setVotos(List<String> votos) {
		this.votos = votos;
	}
	public Pauta(long id, String descricao, Calendar dataCadastro, List<String> votos) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.votos = votos;
	}
	
	public Pauta(long id, String descricao, Calendar dataCadastro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;		
	}
	
	public Pauta() {
				
	}
	
	
}
