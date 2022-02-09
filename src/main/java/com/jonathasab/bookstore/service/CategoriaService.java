package com.jonathasab.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jonathasab.bookstore.domain.Categoria;
import com.jonathasab.bookstore.repositores.CategoriaRepository;
import com.jonathasab.bookstore.service.exceptions.ObjectNotFoundException;

public class CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	public Categoria FindById(Integer id)
	{
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Categoria> FindAll()
	{
		return repository.findAll();
	}
}
