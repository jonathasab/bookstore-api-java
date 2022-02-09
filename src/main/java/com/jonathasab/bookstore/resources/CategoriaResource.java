package com.jonathasab.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathasab.bookstore.domain.Categoria;
import com.jonathasab.bookstore.dtos.CategoriaDto;
import com.jonathasab.bookstore.repositores.CategoriaRepository;
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
}
