# 🎬 Screenmatch – Catálogo de Filmes e Séries com Consumo de API

[![Java](https://img.shields.io/badge/Java-17%2B-007396?logo=java)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![Gson](https://img.shields.io/badge/Gson-2.10.1-blue)](https://github.com/google/gson)
[![OMDB API](https://img.shields.io/badge/OMDB-API-yellow)](https://www.omdbapi.com/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

## Sobre o projeto

Este é o projeto **Screenmatch** desenvolvido durante meus estudos de **Programação Orientada a Objetos (POO)** em Java na Alura.  
Diferente de um catálogo estático, ele **consome a API pública OMDB** para buscar filmes e séries em tempo real, converte o JSON em objetos Java, permite avaliar os títulos, calcular médias, ordenar listas e salvar o resultado em um arquivo JSON.

O projeto foi evoluído desde uma versão simples de cadastro de filmes até uma aplicação completa que integra:
- Requisições HTTP com `HttpClient`
- Desserialização de JSON com **Gson**
- Tratamento de exceções personalizadas
- Persistência em arquivo (`filmes.json`)
- Uso de listas (`ArrayList`, `LinkedList`) e ordenação (`Comparable` / `Comparator`)

## Funcionalidades principais

- 🔍 **Busca de filmes/séries por título** usando a API OMDB (requisições HTTP reais)
- 📦 **Conversão de JSON para objetos** com a biblioteca Gson (incluindo `FieldNamingPolicy` e `setPrettyPrinting`)
- ⭐ **Sistema de avaliação** (notas de 0 a 10) e cálculo de média
- 🎯 **Classificação automática** (interface `Classificavel`) usada pelo `FiltroRecomendacao`
- ⏱️ **Cálculo de tempo total** para maratonar séries ou assistir vários filmes (polimorfismo)
- 📋 **Listagem dinâmica** com `ArrayList` e ordenação (`Comparable` por nome, `Comparator` por ano)
- 💾 **Persistência em arquivo** – salva a lista de todos os títulos buscados em `filmes.json` (JSON formatado)
- 🧪 **Tratamento de exceções** – exceção customizada `ErroDeConversaoDeAnoException`, captura de `NumberFormatException`, `IllegalArgumentException`, `NullPointerException`
- 🎬 **Herança e polimorfismo** – `Titulo` (classe base), `Filme`, `Serie`, `Episodio`
- 📄 **Records** – `TituloOmdb` mapeia a resposta da API de forma imutável e concisa


## Conceitos aplicados

- ✅ **Classes, objetos, encapsulamento** (atributos privados, getters/setters)
- ✅ **Construtores, sobrecarga, `toString()`**
- ✅ **Herança** – `Titulo` → `Filme` / `Serie`
- ✅ **Polimorfismo** – `CalculadoraDeTempo.inclui(Titulo)` aceita qualquer subtipo
- ✅ **Interfaces** – `Classificavel` implementada por `Filme` e `Episodio`
- ✅ **Tratamento de exceções** – `try-catch` e exceção personalizada (`ErroDeConversaoDeAnoException`)
- ✅ **Consumo de API** – `HttpClient`, `HttpRequest`, `HttpResponse` (Java 11+)
- ✅ **Conversão JSON → Objeto** – Gson com `FieldNamingPolicy.UPPER_CAMEL_CASE` e `setPrettyPrinting()`
- ✅ **Record (Java 14+)** – `TituloOmdb` para resposta da API
- ✅ **Coleções** – `ArrayList`, `LinkedList`, `Collections.sort()`, `Comparator.comparing()`
- ✅ **Comparação e ordenação** – `Comparable<T>` (por nome) e `Comparator` (por ano)
- ✅ **Escrita de arquivo** – `FileWriter` gerando `filmes.json` formatado

## Tecnologias

- Java 17 (ou superior)
- Biblioteca **Gson** (Google JSON)
- API **OMDB** (requer chave gratuita)
- IntelliJ IDEA (ou qualquer IDE Java)

## Como executar

### Pré-requisitos

1. **Java 17+** instalado.
2. **Chave de API do OMDB** – obtenha gratuitamente em: [http://www.omdbapi.com/apikey.aspx](http://www.omdbapi.com/apikey.aspx)
3. **Dependência Gson** – se estiver usando Maven, adicione no `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>

Clone o repositório
git clone https://github.com/seu-usuario/screenmatch.git

Configure sua chave da API
No arquivo MainComBusca.java, localize a linha:
String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=66ce98d1";
Substitua 66ce98d1 pela sua chave pessoal.
