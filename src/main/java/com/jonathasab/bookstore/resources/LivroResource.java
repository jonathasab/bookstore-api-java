package com.jonathasab.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jonathasab.bookstore.domain.Livro;
import com.jonathasab.bookstore.dtos.LivroDto;
import com.jonathasab.bookstore.service.LivroService;

@CrossOrigin("*")
@RestController
@RequestMapping("/livros")
public class LivroResource {

	
	@Autowired
	LivroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> FindById(@PathVariable Integer id)
	{
		Livro obj = service.FindById(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Livro>> FindAll()
	{
		List<Livro> list = service.FindAll();		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/FindByCategoriaId")
	public ResponseEntity<List<LivroDto>> FindByCategoriaId(@RequestParam(value="categoria", defaultValue= "0") Integer idCategoria)
	{
		List<Livro> list = service.FindByCategoriaId(idCategoria);
		List<LivroDto> listDto = list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<Livro> Create(@RequestParam(value="categoria", defaultValue= "0") Integer idCategoria, @Valid @RequestBody Livro livro)
	{
		livro = service.Create(idCategoria, livro);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(livro);
	}	

	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> Update(@PathVariable Integer id, @Valid @RequestBody Livro livro)
	{
		livro = service.Update(id, livro);		
		return ResponseEntity.ok().body(livro);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Integer id)
	{
			service.Delete(id);	
			return ResponseEntity.noContent().build();
	}
}
