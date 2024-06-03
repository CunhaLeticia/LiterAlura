package models;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    private String idioma;
    private Integer quantidadeDeDownloads;

    @ManyToOne
    private Person autor;

    public Book() {}

    public Book(String nome, String idioma, Integer quantidadeDeDownloads, Person autor) {
        this.nome = nome;
        this.idioma = idioma;
        this.quantidadeDeDownloads = quantidadeDeDownloads;
        this.autor = autor;
    }

    // Getters e setters

    @Override
    public String toString() {
        return "\n---------------------------------------" +
                "\nNome: " + nome +
                "\nIdioma: " + idioma +
                "\nAutor: " + autor.getNome() +
                "\nQuantidade De Downloads: " + quantidadeDeDownloads;
    }
}
