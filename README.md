# Projeto de Gerenciamento de Academia

Este projeto é um sistema de gerenciamento de academia desenvolvido em Java. Ele permite o cadastro e gerenciamento de alunos, instrutores, planos, presenças e treinos, fornecendo funcionalidades como adicionar e exibir informações relacionadas a cada entidade.

## Funcionalidades

- Cadastro de alunos: permite adicionar e exibir informações dos alunos, como nome, idade, endereço, etc.
- Cadastro de instrutores: permite adicionar e exibir informações dos instrutores, como nome, especialidade, etc.
- Cadastro de planos: permite adicionar e exibir informações dos planos disponíveis na academia, como nome, descrição, valor mensal, etc.
- Registro de presenças: possibilita registrar a presença dos alunos em cada aula, armazenando informações como data, horário e aluno presente.
- Cadastro de treinos: permite agendar treinos para os alunos, registrando informações como exercícios, instrutor responsável, etc.

## Estrutura do projeto

O projeto é composto pelas seguintes classes:

- `Aluno`: representa um aluno da academia, contendo informações pessoais e métodos para manipulação desses dados.
- `Instrutor`: representa um instrutor da academia, com informações sobre especialidade, etc.
- `Plano`: representa um plano disponível na academia, com informações como nome, descrição e valor mensal.
- `Presenca`: representa a presença de um aluno em uma aula, registrando informações como data, horário e aluno presente.
- `Treino`: representa um treino agendado, com informações como instrutor responsável, exercícios, repetições, etc.
- `GestãoAcademia`: classe principal do sistema, responsável por realizar a interação com o usuário e gerenciar as outras entidades.
- `Persistencia`: classe responsável pela serialização e desserialização dos objetos em arquivos, permitindo a persistência dos dados.
- `Dados_json`: realiza operações de leitura e escrita de dados em formato JSON.
- `Teste`: utiliza a classe GestaoAcademia para realizar verificações.
- `Operacoes`: Interface responsavel por receber operacoes de CRUD.



## Utilização do projeto

Para utilizar o projeto, basta baixar ou clonar o repositório e importá-lo em uma IDE Java de sua preferência. Em seguida, compile e execute a classe `Main` para iniciar o sistema de gerenciamento.
