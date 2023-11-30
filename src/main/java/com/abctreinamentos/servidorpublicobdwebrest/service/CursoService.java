package com.abctreinamentos.servidorpublicobdwebrest.service;

import java.util.List;
import java.util.Optional;

import com.abctreinamentos.servidorpublicobdwebrest.entity.Curso;

public interface CursoService {
	
	List<Curso> listAll();
	Optional<Curso> listByIdCurso(long idcurso);
	void save(Curso curso);
	void update(Curso curso);
	void delete(long idcurso);

}
