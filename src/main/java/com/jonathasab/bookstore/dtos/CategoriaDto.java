package com.jonathasab.bookstore.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.jonathasab.bookstore.domain.Categoria;

public class CategoriaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message="Campo NOME é requerido")
	@Length(min=3, max=100, message="Campo NOME deve ter entre 3 e 100 caracteres")
	private String nome;
	@NotEmpty(message="Campo DESCRIÇÃO é requerido")
	@Length(min=3, max=200, message="Campo DESCIÇÃO deve ter entre 3 e 200 caracteres")
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
