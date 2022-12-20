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
public class Sessao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	private Calendar dataCadastro;
	@Column(name="tempo_Expira")
	private int tempoExpira;
	@ManyToOne
	@JoinColumn(name = "fk_pauta")
	private Pauta pauta;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public int getTempoExpira() {
		return tempoExpira;
	}
	public void setTempoExpira(int tempoExpira) {
		this.tempoExpira = tempoExpira;
	}
	public Pauta getPauta() {
		return pauta;
	}
	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}
	public Sessao(long id, Calendar dataCadastro, int tempoExpira, Pauta pauta) {
		super();
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.tempoExpira = tempoExpira;
		this.pauta = pauta;
	}
	
	public Sessao( Calendar dataCadastro, int tempoExpira, Pauta pauta) {	
		
		this.dataCadastro = dataCadastro;
		this.tempoExpira = tempoExpira;
		this.pauta = pauta;
	}
	public Sessao() {
		
	}
	
	
}
