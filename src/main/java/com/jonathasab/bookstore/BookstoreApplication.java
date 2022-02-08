package com.jonathasab.bookstore;

import org.springframework.boot.SpringApplication;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jonathasab.bookstore.domain.Categoria;
import com.jonathasab.bookstore.domain.Livro;
import com.jonathasab.bookstore.repositores.CategoriaRepository;
import com.jonathasab.bookstore.repositores.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros Informatica");
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipson", cat1);
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}
