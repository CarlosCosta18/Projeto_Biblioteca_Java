/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class Funcionario extends Pessoa{
    private int IdFuncionario;
    private String Email;
    private String Setor;
    private static ArrayList<Funcionario> colecaoFuncionario = new ArrayList();

    public Funcionario( String nomeCompleto, String dataNasc, String endereco, int telefone, String Setor) {
        super(nomeCompleto, dataNasc, endereco, telefone);
        this.IdFuncionario = (int)(Math.random()* 9000) + 1000;;
        this.Email = this.IdFuncionario + "@Biblioteca.com";
        this.Setor = Setor;
        colecaoFuncionario.add(this);
    }

    @Override
    public String toString() {
        return "Funcionario{" + "IdFuncionario=" + IdFuncionario + ", Email=" + Email + ", Setor=" + Setor + '}';
    }
    
    
    public static void listaFuncionario(){
        for(Funcionario myFuncionario : colecaoFuncionario ){
            System.out.println("Id Funcionario " + myFuncionario.getIdFuncionario() );
             System.out.println("Nome Funcionario " + myFuncionario.getNomeCompleto());
            System.out.println("--------------------------------------------------");
             
        }
    }
    
    public static void buscaFuncionario(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite o codigo do funcionario para buscar");
        int idFuncionario = teclado.nextInt();
        
        
       for(Funcionario funcionario : colecaoFuncionario){
           if(funcionario.getIdFuncionario() == idFuncionario){
               System.out.println("Nome do Funcionario : " + funcionario.getNomeCompleto());
               System.out.println("Data de Nascimento : " + funcionario.getDataNasc());
               System.out.println("Endereço : " + funcionario.getEndereco());
               System.out.println("Telefone : " + funcionario.getTelefone());
               System.out.println("Setor : " + funcionario.getSetor());
               return;
           }
       }
        System.out.println("Usuário com o ID " + idFuncionario + " não encontrado.");
    }
    
    //Getters e Setter

    public int getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(int IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String Setor) {
        this.Setor = Setor;
    }

    public static ArrayList<Funcionario> getColecaoFuncionario() {
        return colecaoFuncionario;
    }

    public static void setColecaoFuncionario(ArrayList<Funcionario> colecaoFuncionario) {
        Funcionario.colecaoFuncionario = colecaoFuncionario;
    }
    
    
    
    
}
