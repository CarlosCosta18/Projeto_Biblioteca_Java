/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    
     /*
        Carlos Eduardo da Costa Oliveira
        Cassio Silva Melo
        Matheus Burkle
    */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Criando dois usuários
        Usuario usuario1 = new Usuario("Carlos Silva", "01/01/1990", "Rua Exemplo, 123", 987654321, "01/01/2023");
        Usuario usuario2 = new Usuario("Ana Souza", "02/02/1985", "Avenida das Flores, 456", 123456789, "05/02/2023");

        // Criando o primeiro livro e adicionando exemplares
        ArrayList<Exemplar> exemplaresLivro1 = new ArrayList<>();
        Livros livro1 = new Livros("As Aventuras de Java", "João Silva", "Programação", "TechBooks", 2020, exemplaresLivro1);
        livro1.adicionarExemplar(1001, "Novo", "Disponivel", "01/02/2020");
        livro1.adicionarExemplar(1002, "Usado", "Disponivel", "01/03/2020");
        livro1.adicionarExemplar(1003, "Regular", "Disponivel", "01/04/2020");

        // Criando o segundo livro e adicionando exemplares
        ArrayList<Exemplar> exemplaresLivro2 = new ArrayList<>();
        Livros livro2 = new Livros("Aprendendo POO", "Ana Souza", "Programação", "CodeBooks", 2021, exemplaresLivro2);
        livro2.adicionarExemplar(2001, "Novo", "Disponivel", "05/01/2021");
        livro2.adicionarExemplar(2002, "Bom", "Disponivel", "10/02/2021");
        livro2.adicionarExemplar(2003, "Regular", "Disponivel", "15/03/2021");

        System.out.println("\n--- Usuários Criados ---");
        Usuario.mostrarUsuario();

        System.out.println("\n--- Livros Criados ---");
        Livros.mostrarLivros();

        System.out.println("\n--- Realizando Empréstimo para Usuário 1 ---");
        usuario1.realizarEmprestimo();

        System.out.println("\n--- Realizando Empréstimo para Usuário 2 ---");
        usuario2.realizarEmprestimo();

        System.out.println("\n--- Registrando Devolução para Usuário 1 ---");
        usuario1.registrarDevolucao();

        System.out.println("\n--- Registrando Devolução para Usuário 2 ---");
        usuario2.registrarDevolucao();

        System.out.println("\n--- Exemplares Emprestados pelo Usuário 1 ---");
        usuario1.listarExemplaresEmprestados();
        
        System.out.println("\n--- Exemplares Emprestados pelo Usuário 2 ---");
        usuario2.listarExemplaresEmprestados();
    }
}

