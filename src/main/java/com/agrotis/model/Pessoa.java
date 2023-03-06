package com.agrotis.model;

import java.time.LocalDateTime;

import com.agrotis.enums.Laboratorio;
import com.agrotis.enums.Propriedade;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Table(name = "Pessoas")
@Entity(name = "Pessoa")
public class Pessoa {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	@Enumerated(EnumType.STRING)
	private Propriedade propriedade;
	@Enumerated(EnumType.STRING)
	private Laboratorio laboratorio;
	private String observacoes;
	
	
	public Pessoa() {
		super();
	}

	public Pessoa(Long id, String nome, LocalDateTime dataInicial, LocalDateTime dataFinal, Propriedade propriedade,
			Laboratorio laboratorio, String observacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.propriedade = propriedade;
		this.laboratorio = laboratorio;
		this.observacoes = observacoes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDateTime getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDateTime dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDateTime getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Propriedade getPropriedade() {
		return propriedade;
	}
	public void setPropriedade(Propriedade propriedade) {
		this.propriedade = propriedade;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
	

}
