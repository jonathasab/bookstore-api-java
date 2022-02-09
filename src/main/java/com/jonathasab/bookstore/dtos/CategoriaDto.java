package com.jonathasab.bookstore.dtos;

import java.io.Serializable;
import java.util.Objects;


import com.jonathasab.bookstore.domain.Categoria;

public class CategoriaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String descricao;

	public CategoriaDto() {
		super();
	}

	public CategoriaDto(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaDto other = (CategoriaDto) obj;
		return Objects.equals(id, other.id);
	}
}
