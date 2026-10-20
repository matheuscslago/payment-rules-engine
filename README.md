# 💳 Payment Rules Processor

> **Status do Projeto:** 🟡 Em construção!  
> **Escopo do Repositório:** Projeto focado na consolidação de **Fundamentos do Java Core**, **Orientação a Objetos** e **Tratamento Defensivo de Erros**.

---

## 📌 Sobre o Projeto

O **Payment Rules Processor** é um componente de autorização e processamento de transações financeiras desenvolvido em Java puro. 

O objetivo deste repositório é simular o fluxo de validação de regras de negócio em um gateway/checkout financeiro, aplicando na prática conceitos de **Orientação a Objetos (POO)**, **Polimorfismo**, **Encapsulamento** e **Tratamento Defensivo de Exceções**.

---

## 🎯 Propósito & Abordagem de Aprendizado

Diferente de grandes projetos evolutivos de longo prazo ou aplicações prontas que utilizam frameworks complexos, este repositório foi construído com um foco muito claro: **colocar em prática 100% dos conceitos que eu já domino até o momento**, garantindo a entrega de um projeto **isolado, consistente e 100% finalizado**.

### 💡 O que este projeto demonstra:
* **Domínio de Sintaxe e POO:** Uso correto de interfaces, herança, polimorfismo, enums e modificadores de acesso sem dependência de bibliotecas externas.
* **Tratamento Defensivo de Erros:** Criação e disparo de exceções customizadas de negócio (`RuntimeException`) para barrar estados inválidos (ex: falta de limite de crédito ou chave PIX ausente).
* **Organização Profissional:** Separação limpa de responsabilidades por pacotes (`domain`, `interfaces`, `exceptions`, `service`).

> ⚠️ **Nota de Transparência:** Este projeto **não utiliza** frameworks (como Spring Boot), ORMs ou Banco de Dados (como PostgreSQL/Docker), pois foi desenhado intencionalmente para validar os fundamentos da linguagem Java antes de avançar para novas tecnologias da stack backend.

## 👤 Autor
Desenvolvido por Matheus Lago.
