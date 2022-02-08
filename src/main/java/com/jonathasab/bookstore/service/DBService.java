package com.jonathasab.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

import com.jonathasab.bookstore.repositores.CategoriaRepository;
import com.jonathasab.bookstore.repositores.LivroRepository;
import com.jonathasab.bookstore.domain.Categoria;
import com.jonathasab.bookstore.domain.Livro;

@Service
public class DBService {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	LivroRepository livroRepository;
	
	public void InstanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null,"TII","Livros de TI");
		Categoria cat2 = new Categoria(null,"Ficção","Livros de ficão cientíica");
		Categoria cat3 = new Categoria(null,"Biografia","Livro de de biografia");
 
                Livro l1 = new Livro(null,"Nada a Perder","Edir Macedo","História Real",cat3);
		Livro l2 = new Livro(null,"new code","Cleyton L.","...",cat1);
		Livro l3 = new Livro(null,"Second Code","L. Cleyton","...", cat1);
		Livro l4 = new Livro(null,"Namoro Blindado","Renato e Cristiane Cardoso","...", cat3);
		Livro l5 = new Livro(null,"Harry Poter","Ichabode","...",cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l2,l3));
		cat2.getLivros().addAll(Arrays.asList(l5));
		cat3.getLivros().addAll(Arrays.asList(l1,l4));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
