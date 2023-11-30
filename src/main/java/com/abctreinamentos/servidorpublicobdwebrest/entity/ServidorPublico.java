package com.abctreinamentos.servidorpublicobdwebrest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="servidorpublico")
public class ServidorPublico {
	
	@Id
	private Long matricula;
	private String nome;
	private String foto;
	private String orgao;
	private String vinculo;
	private String cargo;
	private String lotacao;
	private String exercicio;
	private String email;
	private String telefone;
	private String celular; 
	private String cpf;
	private String naturalidade;
	
	public ServidorPublico() {
		super();
	}
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
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
	public String getOrgao() {
		return orgao;
	}
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
	public String getVinculo() {
		return vinculo;
	}
	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getLotacao() {
		return lotacao;
	}
	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}
	public String getExercicio() {
		return exercicio;
	}
	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	
	

}
