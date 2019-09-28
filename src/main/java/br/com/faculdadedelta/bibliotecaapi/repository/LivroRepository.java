package br.com.faculdadedelta.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faculdadedelta.bibliotecaapi.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
