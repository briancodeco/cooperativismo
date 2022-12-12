package com.cooperativismo.crm.model;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
@Entity
@Table
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	private String descricao;
	private String identificador;
	@ManyToOne
	@JoinColumn(name = "fk_sessao")
	private Sessao sessao;
	@Column(name="data_cadastro")
	private Calendar dataCadastro;
	
	
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
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public Sessao getSessao() {
		return sessao;
	}
	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	
	
	
	
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Voto(long id, String descricao, String identificador, Sessao sessao,Calendar dataCadastro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.identificador = identificador;
		this.sessao = sessao;
		this.dataCadastro = dataCadastro;
	}
	
	public Voto( String descricao, String identificador, Sessao sessao,Calendar dataCadastro) {	
		
		this.descricao = descricao;
		this.identificador = identificador;
		this.sessao = sessao;
		this.dataCadastro = dataCadastro;
	}
	public Voto() {
		
	}
	
}
