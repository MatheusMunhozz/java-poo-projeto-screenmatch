package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.excessoes.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);

        // ---- NOVO: Prepara o loop ----
        String busca = "";                                  // Inicia vazia para entrar no while
        List<Titulo> titulos = new ArrayList<>();          // Lista que vai acumular os filmes convertidos

        // Configuramos o Gson apenas UMA vez, aqui fora, com pretty printing
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()                       // Para o JSON ficar formatado e legível
                .create();

        // ---- LOOP PRINCIPAL: repete até o usuário digitar "sair" ----
        while (!busca.equalsIgnoreCase("sair")) {           // Enquanto NÃO for "sair"
            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();                     // Lê o nome do filme (ou "sair")

            if (busca.equalsIgnoreCase("sair")) {           // Se o usuário digitou "sair"
                break;                                      // Interrompe o loop imediatamente
            }

            // Se não era "sair", monta a URL e faz a requisição
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=66ce98d1";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println("TituloOmdb: " + meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);   // Construtor que lança ErroDeConversaoDeAnoException
                System.out.println("Titulo convertido:");
                System.out.println(meuTitulo);

                // ---- NOVO: adiciona o filme convertido na lista ----
                titulos.add(meuTitulo);                     // Acumula os filmes com sucesso

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Não encontramos este titulo.");
            }
            // Se ocorrer qualquer exceção acima, o filme NÃO será adicionado à lista,
            // e o loop simplesmente volta para a próxima pergunta.
        }

        // ---- NOVO: Depois do loop, salva a lista em um arquivo JSON ----
        try {
            FileWriter escrita = new FileWriter("filmes.json");  // Cria/abre o arquivo
            escrita.write(gson.toJson(titulos));                 // Converte a lista inteira para JSON e escreve
            escrita.close();                                     // Fecha o arquivo, salvando os dados
            System.out.println("Arquivo filmes.json criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }

        System.out.println("O programa finalizou corretamente!");
    }
}