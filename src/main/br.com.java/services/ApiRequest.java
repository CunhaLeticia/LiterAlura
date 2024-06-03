package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    /**
     * Método para consumir uma API e retornar a resposta como String.
     * @param address o URL da API a ser consumida
     * @return a resposta da API em formato String
     */
    public String consumo(String address) {
        // Cria um cliente HTTP com redirecionamentos automáticos
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        // Cria uma solicitação HTTP GET para o endereço fornecido
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();

        HttpResponse<String> response;

        try {
            // Envia a solicitação e armazena a resposta
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            // Trata exceções de I/O
            throw new RuntimeException("Erro de
