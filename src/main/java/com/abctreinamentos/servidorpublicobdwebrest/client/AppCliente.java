package com.abctreinamentos.servidorpublicobdwebrest.client;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpHeaders;

import com.abctreinamentos.servidorpublicobdwebrest.entity.ServidorPublico;
import com.abctreinamentos.servidorpublicobdwebrest.entity.Curso;

@Controller
public class AppCliente {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*********** API SERVIDORPUBLICO *************/
	@GetMapping("/listagemServidores")
	public String listarServidores(Model model) {
		
		String url = "http://localhost:8080/listarServidores"; 
		
	    ResponseEntity<List<ServidorPublico>> response = restTemplate.exchange(
	        url,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<ServidorPublico>>() {}
	    );
		
		List<ServidorPublico> servidorespublicos = response.getBody();
		
		model.addAttribute("servidorespublicos",servidorespublicos);
		
		return "/servidorpublico/servidorespublicos";	
	}

	@GetMapping("/listaServidor/{matricula}")
	public String listarServidor(@PathVariable long matricula, Model model) {
		
		String url = "http://localhost:8080/listarServidor/{matricula}"; 
		
	    ResponseEntity<ServidorPublico> response = restTemplate.exchange(
	        url,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<ServidorPublico>() {},matricula
	    );
		
		ServidorPublico servidorpublico = response.getBody();
		
		model.addAttribute("servidorpublico",servidorpublico);
		
		return "/servidorpublico/servidorpublico";
	
	}

	@GetMapping("/exclusaoServidor/{matricula}")
	public String excluirServidor(@PathVariable long matricula) {
		
		String url = "http://localhost:8080/excluirServidor/{matricula}"; 
		
		ResponseEntity<ServidorPublico> response = restTemplate.exchange(
		        url,
		        HttpMethod.DELETE,
		        null,
		        ServidorPublico.class,
		        matricula
		    );
		
		return "redirect:/listagemServidores";
	}
	
	@GetMapping("/formNovoServidor")
	public String formNovoServidor(Model model)
	{
		model.addAttribute("servidorPublico",new ServidorPublico());
		return "servidorpublico/novoservidorpublico";
	}
	
	@PostMapping("/cadastroServidor")
	public String cadastrarServidor(ServidorPublico novoservidor, Model model) {
	   
		String url = "http://localhost:8080/cadastrarServidor"; 
		
		ResponseEntity<ServidorPublico> response = restTemplate.exchange(
	        url,
	        HttpMethod.POST,
	        new HttpEntity<>(novoservidor),
	        ServidorPublico.class
	    );

	    if (response.getStatusCode() == HttpStatus.OK)
	    	return "redirect:/listagemServidores";
	    else
	    {
	    	model.addAttribute("mensagem",response.getStatusCode());
	    	return "/erro/mensagem";
	    }
	}

	@GetMapping("/formEditarServidor/{matricula}")
	public String formEditarServidor(@PathVariable long matricula, Model model)
	{
		String url = "http://localhost:8080/listarServidor/{matricula}"; 
		
	    ResponseEntity<ServidorPublico> response = restTemplate.exchange(
	        url,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<ServidorPublico>() {},matricula
	    );
		
		ServidorPublico servidorpublico = response.getBody();
		
		model.addAttribute("servidorpublico",servidorpublico);
		
		return "/servidorpublico/editarservidorpublico";
	}
	
	@PostMapping("/edicaoServidor/{matricula}")
	public String editarServidor(@PathVariable long matricula, ServidorPublico servidor)
	{
		String url = "http://localhost:8080/editarServidor/{matricula}"; 
		
		ResponseEntity<ServidorPublico> response = restTemplate.exchange(
	        url,
	        HttpMethod.PUT,
	        new HttpEntity<>(servidor),
	        ServidorPublico.class,matricula);

	  	return "redirect:/listagemServidores";
	}
	
	/*********** API curso *************/
	@GetMapping("/listagemCursos")
	public String listarCursos(Model model) {
		
		String url = "http://localhost:8080/listarCursos"; 
		
	    ResponseEntity<List<Curso>> response = restTemplate.exchange(
	        url,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<Curso>>() {}
	    );
		
		List<Curso> cursos = response.getBody();
		
		model.addAttribute("cursos",cursos);
		
		return "/curso/cursos";	
	}

	@GetMapping("/listaCurso/{idcurso}")
	public String listarCurso(@PathVariable long idcurso, Model model) {
		
		String url = "http://localhost:8080/listarCurso/{idcurso}"; 
		
	    ResponseEntity<Curso> response = restTemplate.exchange(
	        url,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<Curso>() {},idcurso
	    );
		
		Curso curso = response.getBody();
		
		model.addAttribute("curso",curso);
		
		return "/curso/curso";
	
	}

	@GetMapping("/exclusaoCurso/{idcurso}")
	public String excluirCurso(@PathVariable long idcurso) {
		
		String url = "http://localhost:8080/excluirCurso/{idcurso}"; 
		
		
		ResponseEntity<Curso> response = restTemplate.exchange(
		        url,
		        HttpMethod.DELETE,
		        null,
		        Curso.class,
		        idcurso
		    );
		
		return "redirect:/listagemCursos";
	}
	
	@GetMapping("/formNovoCurso")
	public String formNovoCurso(Model model)
	{
		model.addAttribute("curso",new Curso());
		return "curso/novocurso";
	}
	
	@PostMapping("/cadastroCurso")
	public String cadastrarCurso(Curso novocurso, Model model) {
	   
		String url = "http://localhost:8080/cadastrarCurso"; 
		
		ResponseEntity<Curso> response = restTemplate.exchange(
	        url,
	        HttpMethod.POST,
	        new HttpEntity<>(novocurso),
	        Curso.class
	    );

	    if (response.getStatusCode() == HttpStatus.CREATED)
	    	return "redirect:/listagemCursos";
	    else
	    {
	    	model.addAttribute("mensagem",response.getStatusCode());
	    	return "/erro/mensagem";
	    }
	}

	@GetMapping("/formEditarCurso/{idcurso}")
	public String formEditarCurso(@PathVariable long idcurso, Model model)
	{
		String url = "http://localhost:8080/listarCurso/{idcurso}"; 
		
	    ResponseEntity<Curso> response = restTemplate.exchange(
	        url,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<Curso>() {},idcurso
	    );
		
		Curso curso = response.getBody();
		
		model.addAttribute("curso",curso);
		
		return "/curso/editarcurso";
	}
	
	@PostMapping("/edicaoCurso/{idcurso}")
	public String editarServidor(@PathVariable long idcurso, Curso curso)
	{
		String url = "http://localhost:8080/editarCurso/{idcurso}"; 
		
		ResponseEntity<Curso> response = restTemplate.exchange(
	        url,
	        HttpMethod.PUT,
	        new HttpEntity<>(curso),
	        Curso.class,idcurso);

	  	return "redirect:/listagemCursos";
	}
	

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Object> handleNotFoundException(ResponseStatusException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", ex.getReason());
		body.put("status", ex.getStatusCode());
		return new ResponseEntity<>(body, ex.getStatusCode());
	} 
	
}
