package com.abctreinamentos.servidorpublicobdwebrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abctreinamentos.servidorpublicobdwebrest.entity.ServidorPublico;

@Repository
public interface ServidorPublicoRepository extends CrudRepository<ServidorPublico,Long> {

}
