package com.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursomc.domain.entity.Categoria;
import com.cursomc.domain.entity.Produto;
import com.cursomc.repository.CategoriaRepository;
import com.cursomc.repository.ProdutoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Override
    public void run(String... args) throws Exception {
//        // Deleta todas as categorias e produtos existentes
//        this.categoriaRepository.deleteAll();
//        this.produtoRepository.deleteAll();
//        
        // Cria categorias
        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");
        // Salva as categorias
        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        
        // Cria produtos
        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora" , 800.00 );
        Produto p3 = new Produto(null, "Mouse", 80.00 );
        
        // Associa produtos às categorias
        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);
        
        // Salva os produtos
        this.produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        
        // Atualiza as categorias com os produtos
        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().add(p2);
        
        // Salva as categorias novamente para atualizar as associações
        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
    }
}
