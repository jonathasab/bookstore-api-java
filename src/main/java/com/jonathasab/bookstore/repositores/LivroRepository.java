package com.jonathasab.bookstore.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jonathasab.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

	@Query("select obj from Livro obj where obj.categoria.id = idCategoria")
	public List<Livro> FindByCategoriaId(@Param(value="idCategoria") Integer idCategoria);

}
