/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author Carlos 
 */
public class Pessoa {
    private String nomeCompleto; 
    private String dataNasc;
    private String endereco;
    private int telefone;
   
    
    //Construtor
    public Pessoa(String nomeCompleto, String dataNasc, String endereco, int telefone) {
        this.nomeCompleto = nomeCompleto;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    
    //getter e setters
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    
    
}
