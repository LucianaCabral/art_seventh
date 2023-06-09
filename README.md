# art_seventh
## Challenge Movies 🎥 🚧
Objetivos
Exibir a tela de splash que contenha o canal de contato
Exibir uma tela principal do app que tem os seguintes fluxos: filmes, séries e contato
Exibir uma lista de filmes mais populares
Exibir uma lista das tendâncias
Conter uma uma busca na tela da lista de filmes Ao clicar em um item dessa lista, mostrar a tela 
com os detalhes do filme contendo as seguintes informações: gênero, pontuação, sinopse, ano, atores

________________________________________________________________________________________________

## Arquitetura do app
A arquitetura do app será implementada em 3 camadas utilizando o padrão MVVM nas camadas da view e 
o Clean Code nas camadas para deixar as regras de negócio desacopladas da UI afim de que mudanças 
não alterem o comportamento de outras camadas.

Para estabelecer a comunicação entre as camadas será utlizado omcorroutines e flow. 
O ponto de entrada do app será a activity na home e o fluxo de navegação será realizado através do 
componente de navegação entre os fragments.

Serão utilizados também os seguintes padrões e componentes para o desenvolvimento do aplicativo:

* Injeção de dependência com o Koin
* Telas com estados(loading, error, success)
* Coroutines e Flow para fazer a comunicação entre as camadas
* RecyclerView view para as listas
* View Binding para obter mais segurança em interagir com view
* Modularização
______________________________________________________________________________

Estrutura dos pacotes No projeto temos 3 pacotes principais:

📦 data

📦 domain

📦 presentation

API Utilizada: https://api.themoviedb.org/
Arquitetura do App: 

https://www.notion.so/Criar-REPO-no-Git-e-integrar-projeto-android-studio-3199448241da4308a99fbdc1a5c0d789

[![kotlin](https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white)](#kotlin) [![notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white)](#notion) [![Trello](https://img.shields.io/badge/Trello-0052CC?style=for-the-badge&logo=trello&logoColor=white)](#trello) [![Git](https://img.shields.io/badge/Git-E34F26?style=for-the-badge&logo=git&logoColor=white)](#git) [![License](https://img.shields.io/badge/License-MIT-blue)](#license)