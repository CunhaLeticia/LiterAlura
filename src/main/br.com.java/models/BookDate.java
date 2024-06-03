package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Record para representar dados de um livro, mapeados a partir de um JSON.
 *
 * @param nomeDoLivro O nome do livro.
 * @param quantidadeDeDownloads A quantidade de downloads do livro.
 * @param idiomas A lista de idiomas disponíveis para o livro.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("title") String nomeDoLivro,
        @JsonAlias("download_count") Integer quantidadeDeDownloads,
        @JsonAlias("languages") List<String> idiomas) {
}
