package com.abctreinamentos.servidorpublicobdwebrest.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.abctreinamentos.servidorpublicobdwebrest.entity.ServidorPublico;

/**************************************/
public interface ServidorPublicoAPIRest 
/**************************************/
{
	
	@GetMapping("/listarServidores")
	public ResponseEntity<List<ServidorPublico>> listarServidores();

	@GetMapping("/listarServidor/{matricula}")
	public ResponseEntity<ServidorPublico> listarServidor(@PathVariable long matricula);
	
	@DeleteMapping("/excluirServidor/{matricula}")
	public void excluirServidor(@PathVariable long matricula);
	
	@PutMapping("/editarServidor/{matricula}")
	public String editarServidor(@PathVariable long matricula, @RequestBody ServidorPublico servidor);
	
	@PostMapping("/cadastrarServidor")
	public String cadastrarServidor(@RequestBody ServidorPublico novoservidor);

}
