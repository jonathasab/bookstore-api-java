package com.jonathasab.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jonathasab.bookstore.domain.Livro;
import com.jonathasab.bookstore.repositores.LivroRepository;
import com.jonathasab.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	
	@Autowired
	LivroRepository repository;
	
	@Autowired
	CategoriaService serviceCategoria;
	
	public Livro FindById(Integer id)
	{
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Livro> FindAll()
	{
		return repository.findAll();
	}
	
	public List<Livro> FindByCategoriaId(Integer idCategoria)
	{
		serviceCategoria.FindById(idCategoria);
		return repository.FindByCategoriaId(idCategoria);
	}
	
	public Livro Create(Integer idCategoria, Livro livro)
	{
		livro.setCategoria(serviceCategoria.FindById(idCategoria));
		livro.setId(null);
		Livro obj = repository.save(livro);
		
		return obj;
	}
	

	public Livro Update(Integer id, Livro livro)
	{
		Livro obj = FindById(id);
		
		 obj.setNomeAutor(livro.getNomeAutor());
		 obj.setTitulo(livro.getTitulo());
		 obj.setTexto(livro.getTexto());	
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
