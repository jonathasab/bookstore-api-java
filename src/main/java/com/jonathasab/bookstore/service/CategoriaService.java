package com.jonathasab.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.jonathasab.bookstore.domain.Categoria;
import com.jonathasab.bookstore.repositores.CategoriaRepository;

public class CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	public Categoria FindById(Integer id)
	{
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
