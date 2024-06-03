// Adicionar tratamento de exceções mais específico
private void buscarNovoLivro() {
    System.out.println("\nQual livro deseja buscar?");
    var buscaDoUsuario = sc.nextLine();
    var dados = requisicao.consumo(ADDRESS + buscaDoUsuario.replace(" ", "%20"));
    if (dados != null) {
        salvarNoDb(dados);
    } else {
        System.out.println("\n\n***Falha ao buscar o livro. Tente novamente.***\n\n");
    }
}

// Adicionar tratamento de exceções mais específico
private void salvarNoDb(String dados) {
    try {
        // seu código de salvamento aqui
    } catch (NullPointerException e) {
        System.out.println("\n\n*** Livro não encontrado ou dados inválidos. ***\n\n");
    }
}

// Encapsular lógica de impressão
private void imprimirLista(String titulo, List<?> lista) {
    System.out.println("\n" + titulo + ":");
    if (!lista.isEmpty()) {
        lista.forEach(System.out::println);
    } else {
        System.out.println("\nNenhum item encontrado.");
    }
}

// Adicionar tratamento de exceções mais específico
private void buscarLivrosPorIdioma() {
    var idiomasCadastrados = repositorioLivro.bucasidiomas();
    imprimirLista("Idiomas cadastrados no banco", idiomasCadastrados);
    System.out.println("\nSelecione um dos idiomas cadastrados no banco:\n");
    var idiomaSelecionado = sc.nextLine();
    try {
        var livrosPorIdioma = repositorioLivro.buscarPorIdioma(idiomaSelecionado);
        imprimirLista("Livros em " + idiomaSelecionado, livrosPorIdioma);
    } catch (Exception e) {
        System.out.println("\n\n***Falha ao buscar livros por idioma. Tente novamente.***\n\n");
    }
}
