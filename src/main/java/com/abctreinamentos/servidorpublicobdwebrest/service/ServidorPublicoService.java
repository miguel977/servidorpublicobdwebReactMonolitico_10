package com.abctreinamentos.servidorpublicobdwebrest.service;

import java.util.List;
import java.util.Optional;

import com.abctreinamentos.servidorpublicobdwebrest.entity.ServidorPublico;

public interface ServidorPublicoService {
	
	List<ServidorPublico> listAll();
	Optional<ServidorPublico> listByMatricula(long matricula);
	void save(ServidorPublico servidor);
	void update(ServidorPublico servidor);
	void delete(long matricula);

}
