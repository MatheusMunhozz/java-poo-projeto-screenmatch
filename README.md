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

## Estrutura do projeto
