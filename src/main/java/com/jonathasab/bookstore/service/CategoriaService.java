package com.jonathasab.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jonathasab.bookstore.domain.Categoria;
import com.jonathasab.bookstore.dtos.CategoriaDto;
import com.jonathasab.bookstore.repositores.CategoriaRepository;
import com.jonathasab.bookstore.service.exceptions.ObjectNotFoundException;

@Service
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
	
	public Categoria Create(Categoria categoria)
	{
		categoria.setId(null);
		Categoria obj = repository.save(categoria);
		
		return obj;
	}
	

	public Categoria Update(Integer id, CategoriaDto categoria)
	{
		Categoria obj = FindById(id);
		
		 obj.setNome(categoria.getNome());
		 obj.setDescricao(categoria.getDescricao());	
		return repository.save(obj);
	}
	
	public void Delete(Integer id)
	{
		try
		{
			FindById(id);
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e)
		{
			throw new com.jonathasab.bookstore.service.exceptions.DataIntegrityViolationException("Categoria não pode excluida porque possui livros associados a ela.");
		}
	}
}
