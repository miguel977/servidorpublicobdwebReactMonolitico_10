package com.abctreinamentos.servidorpublicobdwebrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abctreinamentos.servidorpublicobdwebrest.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso,Long> {

}
