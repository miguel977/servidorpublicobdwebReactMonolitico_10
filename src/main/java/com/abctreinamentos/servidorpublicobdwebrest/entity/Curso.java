package com.abctreinamentos.servidorpublicobdwebrest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcurso;
	private String nome;
    private String foto;
    private String formarealizacao;
	private String ofertante;
    private int vagas;
    private double valor;
    private String site;
    private String situacao;
    
	public Curso() {
		super();
	}
	public Long getIdcurso() {
		return idcurso;
	}
	public void setIdcurso(Long idcurso) {
		this.idcurso = idcurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
    public String getFormarealizacao() {
		return formarealizacao;
	}
	public void setFormarealizacao(String formarealizacao) {
		this.formarealizacao = formarealizacao;
	}
	public String getOfertante() {
		return ofertante;
	}
	public void setOfertante(String ofertante) {
		this.ofertante = ofertante;
	}
	public int getVagas() {
		return vagas;
	}
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
    
    
    
}
