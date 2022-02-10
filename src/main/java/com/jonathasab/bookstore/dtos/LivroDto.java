package com.jonathasab.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.jonathasab.bookstore.domain.Livro;

public class LivroDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message="Campo TITULO é requerido")
	@Length(min=3, max=100, message="Campo TITULO deve ter entre 3 e 100 caracteres")
	private String titulo;

	public LivroDto() {
		super();
	}

	public LivroDto(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
