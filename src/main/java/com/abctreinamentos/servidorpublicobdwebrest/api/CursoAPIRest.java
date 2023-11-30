package com.abctreinamentos.servidorpublicobdwebrest.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.abctreinamentos.servidorpublicobdwebrest.entity.Curso;

/**************************************/
public interface CursoAPIRest 
/**************************************/
{
	
	@GetMapping("/listarCursos")
	public ResponseEntity<List<Curso>> listarCursos();

	@GetMapping("/listarCurso/{idcurso}")
	public ResponseEntity<Curso> listarCurso(@PathVariable long idcurso);
	
	@DeleteMapping("/excluirCurso/{idcurso}")
	public void excluirCurso(@PathVariable long idcurso);
	
	@PutMapping("/editarCurso/{idcurso}")
	public String editarCurso(@PathVariable long idcurso, @RequestBody Curso curso);
	
	@PostMapping("/cadastrarCurso")
	public String cadastrarCurso(@RequestBody Curso novocurso);

}
