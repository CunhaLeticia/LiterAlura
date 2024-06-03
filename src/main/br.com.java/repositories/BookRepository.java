package repositories;

import models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Verifica se existe um livro com o nome fornecido.
     *
     * @param nome o nome do livro
     * @return true se existir um livro com o nome fornecido, caso contrário false
     */
    boolean existsByNome(String nome);

/**
 * Busca e retorna uma lista de idiomas distintos dos livros, ordenados alfabeticamente.
 *
 * @return uma lista de idiomas distintos
 *
