package com.jonathasab.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jonathasab.bookstore.domain.Categoria;
import com.jonathasab.bookstore.dtos.CategoriaDto;
import com.jonathasab.bookstore.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	
	@Autowired
	CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> FindById(@PathVariable Integer id)
	{
		Categoria obj = service.FindById(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDto>> FindAll()
	{
		List<Categoria> list = service.FindAll();
		List<CategoriaDto> listDto = list.stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> Create(@RequestBody Categoria categoria)
	{
		categoria = service.Create(categoria);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(categoria);
	}	

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDto> Update(@PathVariable Integer id, @RequestBody CategoriaDto categoriaDto)
	{
		Categoria categoria = service.Update(id, categoriaDto);		
		return ResponseEntity.ok().body(new CategoriaDto(categoria));
	}
	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Integer id)
	{
			service.Delete(id);	
			return ResponseEntity.noContent().build();
	}
}
