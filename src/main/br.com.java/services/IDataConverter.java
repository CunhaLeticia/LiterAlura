package services;

import models.AuthorData;
import models.BookData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter {
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Converte uma string JSON em um objeto do tipo especificado.
     *
     * @param json a string JSON a ser convertida
     * @param classe a classe do tipo T para a conversão
     * @param <T> o tipo de retorno
     * @return o objeto convertido do tipo T
     */
    @Override
    public <T> T getData(String json, Class<T> classe) {
        try {
            JsonNode node = mapper.readTree(json);
            JsonNode targetNode;

            if (classe == BookData.class) {
                targetNode = node.get("results").get(0);
            } else if (classe == AuthorData.class) {
                targetNode = node.get("results").get(0).get("authors").get(0);
            } else {
                return mapper.readValue(json, classe);
            }

            return mapper.treeToValue(targetNode, classe);

        } catch (JsonProcessingException e) {
            // Imprime a pilha de execução para ajudar na depuração
            e.printStackTrace();
            throw new RuntimeException("Erro ao processar JSON: " + e.getMessage(), e);
        }
    }
}
