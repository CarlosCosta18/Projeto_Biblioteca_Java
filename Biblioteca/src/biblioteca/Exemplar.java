/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author Carlos
 */
public class Exemplar{
    private int exemplar;
    private String estadoCon;
    private String disponibilidade;
    private String dataAquisicao;
    private Date dataEmprestimo;
    private Date dataDevolucaoPrevista;
    private static ArrayList<Exemplar> exemplaresExistentes = new ArrayList<>();

    public Exemplar(int exemplar, String estadoCon, String disponibilidade, String dataAquisicao) {
        
        this.exemplar = exemplar;
        this.estadoCon = estadoCon;
        this.disponibilidade = disponibilidade;
        this.dataAquisicao = dataAquisicao;
        exemplaresExistentes.add(this);
    }
    
    
    
    public void MudarDisponibilidade(String status){
        this.disponibilidade = status;
    }
    
   public static void buscaExemplar(){
        Scanner teclado = new Scanner(System.in);   
        System.out.println("Digite o codigo do exemplar para buscar");
        
        int exemplar = teclado.nextInt();
        for(Exemplar myexemplar : exemplaresExistentes  ){
            if(myexemplar.getExemplar() == exemplar){
                System.out.println("Estado de Conservação: " + myexemplar.getEstadoCon());
                System.out.println("Disponibilidade: " + myexemplar.getDisponibilidade());
                System.out.println("Data de Aquisição: " + myexemplar.getDataAquisicao());
                System.out.println("----------------------------------");
                return;
            }
        }
        System.out.println("O exemplar " + exemplar + "não existe");
    }
    
    //Getter e Setters
    public int getExemplar() {
        return exemplar;
    }

    public void setExemplar(int exemplar) {
        this.exemplar = exemplar;
    }

    public String getEstadoCon() {
        return estadoCon;
    }

    public void setEstadoCon(String estadoCon) {
        this.estadoCon = estadoCon;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public static ArrayList<Exemplar> getExemplaresExistentes() {
        return exemplaresExistentes;
    }

    public static void setExemplaresExistentes(ArrayList<Exemplar> exemplaresExistentes) {
        Exemplar.exemplaresExistentes = exemplaresExistentes;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }
    
    
    
    
}
