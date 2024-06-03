package repositories;

import models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Person, Long> {

    /**
     * Verifica se existe um autor com o nome fornecido.
     *
     * @param nome o nome do autor
     * @return true se existir um autor com o nome fornecido, caso contrário false
     */
    Boolean existsByNome(String nome);

/**
 * Encontr
