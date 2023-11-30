package com.abctreinamentos.servidorpublicobdwebrest.controller;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abctreinamentos.servidorpublicobdwebrest.api.CursoAPIRest;
import com.abctreinamentos.servidorpublicobdwebrest.api.ServidorPublicoAPIRest;
import com.abctreinamentos.servidorpublicobdwebrest.entity.Curso;
import com.abctreinamentos.servidorpublicobdwebrest.entity.ServidorPublico;
import com.abctreinamentos.servidorpublicobdwebrest.service.CursoService;
import com.abctreinamentos.servidorpublicobdwebrest.service.ServidorPublicoService;

@RestController
public class AppController implements ServidorPublicoAPIRest, CursoAPIRest{
	
	private ServidorPublicoService servidorService;
	private CursoService cursoService;
	
	@Autowired
	public void setServidorPublicoService(ServidorPublicoService servidorService)
	{
		this.servidorService = servidorService;
	}
	
	@Autowired
	public void setCursoService(CursoService cursoService)
	{
		this.cursoService = cursoService;
	}

	/*********** API SERVIDORPUBLICO *************/
	@GetMapping("/listarServidores")
	public ResponseEntity<List<ServidorPublico>> listarServidores() {
		List<ServidorPublico> servidorespublicos = servidorService.listAll();
		return new ResponseEntity<List<ServidorPublico>>(servidorespublicos,HttpStatus.OK);
	}

	@GetMapping("/listarServidor/{matricula}")
	public ResponseEntity<ServidorPublico> listarServidor(long matricula) {
		
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
		
		if (servidorEncontrado.isPresent())
			return new ResponseEntity<ServidorPublico>(servidorEncontrado.get(),HttpStatus.OK);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Servidor Público Não Encontrado");
	}

	@DeleteMapping("/excluirServidor/{matricula}")
	public void excluirServidor(long matricula) {
		
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
		
		if (servidorEncontrado.isPresent())
		{
			servidorService.delete(matricula);
			throw new ResponseStatusException(HttpStatus.OK,"Servidor Público Excluído");
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Servidor Público Não Encontrado");
	}

	@PutMapping("/editarServidor/{matricula}")
	public String editarServidor(long matricula, @RequestBody ServidorPublico servidorAlterado) {
		
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
		
		if (servidorEncontrado.isPresent())
		{
			servidorService.update(servidorAlterado);
			throw new ResponseStatusException(HttpStatus.OK,"Servidor Público Alterado");
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Servidor Público Não Encontrado");

	}

	@PostMapping("/cadastrarServidor")
	public String cadastrarServidor(@RequestBody ServidorPublico novoservidor) {
		
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(novoservidor.getMatricula());
		
		if (!servidorEncontrado.isPresent())
		{
			servidorService.save(novoservidor);
			throw new ResponseStatusException(HttpStatus.OK,"Servidor Público Cadastrado");
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Servidor Público Já Existente");	
	}
	
	/*********** API CURSO *************/
	@GetMapping("/listarCursos")
	public ResponseEntity<List<Curso>> listarCursos() {
		List<Curso> cursos = cursoService.listAll();
		return new ResponseEntity<List<Curso>>(cursos,HttpStatus.OK);
	}

	@GetMapping("/listarCurso/{idcurso}")
	public ResponseEntity<Curso> listarCurso(long idcurso) {
		
		Optional<Curso> cursoEncontrado = cursoService.listByIdCurso(idcurso);
		
		if (cursoEncontrado.isPresent())
			return new ResponseEntity<Curso>(cursoEncontrado.get(),HttpStatus.OK);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso Não Encontrado");
	}

	@DeleteMapping("/excluirCurso/{idcurso}")
	public void excluirCurso(long idcurso) {
		
		Optional<Curso> cursoEncontrado = cursoService.listByIdCurso(idcurso);
		
		if (cursoEncontrado.isPresent())
		{
			cursoService.delete(idcurso);
			throw new ResponseStatusException(HttpStatus.OK,"Curso Excluído");
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso Não Encontrado");
	}

	@PutMapping("/editarCurso/{idcurso}")
	public String editarCurso(long idcurso, @RequestBody Curso cursoAlterado) {
		
		Optional<Curso> cursoEncontrado = cursoService.listByIdCurso(idcurso);
		
		if (cursoEncontrado.isPresent())
		{
			cursoService.update(cursoAlterado);
			throw new ResponseStatusException(HttpStatus.OK,"Curso Alterado");
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso Não Encontrado");

	}

	@PostMapping("/cadastrarCurso")
	public String cadastrarCurso(@RequestBody Curso novocurso) {
		
		cursoService.save(novocurso);
		throw new ResponseStatusException(HttpStatus.CREATED,"Curso Cadastrado");
	}
	
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Object> handleNotFoundException(ResponseStatusException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", ex.getReason());
		body.put("status", ex.getStatusCode());
		return new ResponseEntity<>(body, ex.getStatusCode());
	}
}
