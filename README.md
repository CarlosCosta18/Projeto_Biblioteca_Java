# Projeto_Biblioteca_Java
Projeto da Disciplina de Progamação de Sistemas/ 2º Semestre

Este projeto é um sistema para gerenciamento de uma biblioteca, desenvolvido em Java. Ele permite gerenciar usuários, funcionários, livros, exemplares, empréstimos e devoluções, oferecendo funcionalidades obrigatórias e extras.

## 📚 Funcionalidades Principais

### Funcionalidades Obrigatórias
1. **Buscar informações**:
   - Usuário pelo número de registro.
   - Funcionário pelo número de identificação.
   - Livro pelo código.
   - Exemplar pelo código.

2. **Listar registros**:
   - Usuários (número de registro, nome, data de cadastro).
   - Funcionários (ID, nome).
   - Livros (código, título, autor, gênero).
   - Exemplares disponíveis de um livro.

3. **Registrar empréstimos**:
   - Realizar empréstimos para usuários.

### Funcionalidades Extras
1. **Contar empréstimos ativos de um usuário**:
   - Retorna o número de exemplares emprestados pelo usuário.

2. **Listar exemplares emprestados por um usuário**:
   - Exibe todos os exemplares emprestados e o total de empréstimos ativos.

## 🛠️ Estrutura do Sistema

### Classes Principais
- **Pessoa**: Base para `Usuário` e `Funcionário`, com atributos como nome, data de nascimento, endereço e telefone.
- **Usuário**: Representa os usuários da biblioteca, com atributos como ID, e-mail e data de cadastro. Inclui métodos para gerenciar empréstimos.
- **Funcionário**: Representa os funcionários, com atributos como ID e senha.
- **Livros**: Representa os livros cadastrados, com informações como título, autor, gênero e ano de publicação.
- **Exemplar**: Representa os exemplares físicos de livros, com estado de conservação, disponibilidade e datas relacionadas a empréstimos.

## 🔍 Exemplos de Execução

### Criação de Usuários
```java
Usuario usuario1 = new Usuario("Carlos Silva", "01/01/1990", "Rua Exemplo, 123", 987654321, "01/01/2023");
Usuario usuario2 = new Usuario("Ana Souza", "02/02/1985", "Avenida das Flores, 456", 123456789, "05/02/2023");
Criação de Livros e Exemplares
java
Copiar código
ArrayList<Exemplar> exemplaresLivro1 = new ArrayList<>();
Livros livro1 = new Livros("As Aventuras de Java", "João Silva", "Programação", "TechBooks", 2020, exemplaresLivro1);
livro1.adicionarExemplar(1001, "Novo", "Disponivel", "01/02/2020");
livro1.adicionarExemplar(1002, "Usado", "Disponivel", "01/03/2020");
livro1.adicionarExemplar(1003, "Regular", "Disponivel", "01/04/2020");

ArrayList<Exemplar> exemplaresLivro2 = new ArrayList<>();
Livros livro2 = new Livros("Aprendendo POO", "Ana Souza", "Programação", "CodeBooks", 2021, exemplaresLivro2);
livro2.adicionarExemplar(2001, "Novo", "Disponivel", "05/01/2021");
livro2.adicionarExemplar(2002, "Bom", "Disponivel", "10/02/2021");
livro2.adicionarExemplar(2003, "Regular", "Disponivel", "15/03/2021");
```

## 📂 Estrutura de Arquivos

- **src/**: Contém os arquivos de código-fonte do sistema.
  - `Pessoa.java`: Classe base para Usuário e Funcionário.
  - `Usuario.java`: Classe que representa os usuários da biblioteca.
  - `Funcionario.java`: Classe que representa os funcionários da biblioteca.
  - `Livros.java`: Classe para gerenciar os livros no sistema.
  - `Exemplar.java`: Classe para gerenciar os exemplares físicos dos livros.
  - `Main.java`: Classe principal para execução e testes do sistema.

## 🚀 Como Executar

1. Clone o repositório em sua máquina local:
   ```bash
   git clone https://github.com/seu-usuario/sistema-biblioteca.git
   cd sistema-biblioteca
Compile os arquivos Java:

bash
Copiar código
javac src/*.java
Execute o programa:

bash
Copiar código
java src.Main
Certifique-se de que você tenha o Java Development Kit (JDK) instalado em sua máquina para compilar e executar o projeto.

📜 Licença
Este projeto está licenciado sob a MIT License. Você pode utilizá-lo, modificar e distribuir livremente, desde que mencione a autoria original.

👨‍💻 Autoria
Projeto desenvolvido por Carlos Eduardo da Costa Oliveira.
