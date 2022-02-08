package com.jonathasab.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathasab.bookstore.domain.Categoria;
import com.jonathasab.bookstore.repositores.CategoriaRepository;
import com.jonathasab.bookstore.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {


	@Autowired
	CategoriaService service;
	
	public ResponseEntity<Categoria> FindById(@PathVariable Integer id)
	{
		Categoria obj = service.FindById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
