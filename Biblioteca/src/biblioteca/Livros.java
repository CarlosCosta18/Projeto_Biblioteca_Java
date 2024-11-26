/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    package biblioteca;

    import java.util.ArrayList;
    import java.util.Date;
    import java.util.Scanner;

    /**
     *
     * @author Carlos
     */
    public class Livros{
        private int codLivro;
        private String titulo;
        private String autor;
        private String genero;
        private String editora;
        private int anoPublicacao;
        private static ArrayList<Livros> colecaoLivros = new ArrayList<>();
        private ArrayList<Exemplar> codExemplares;


        //Cria o livro
        public Livros(String titulo, String autor, String genero, String editora, int anoPublicacao, ArrayList<Exemplar> codExemplares){
            this.codLivro = (int)(Math.random()* 9000) + 1000;
            this.titulo = titulo;
            this.autor = autor;
            this.genero = genero;
            this.editora = editora;
            this.anoPublicacao = anoPublicacao;
            this.codExemplares = new ArrayList<Exemplar>();

            colecaoLivros.add(this);
        }



        //Adiciona o exemplar atraves do construtor de Exemplar
        public void adicionarExemplar(int codExemplar, String estadoCon, String disponibilidade, String dataAquisicao) {
        for (Exemplar exemplar : codExemplares) {
            if (exemplar.getExemplar() == codExemplar) {
                System.out.println("Já existe um exemplar com esse código: " + codExemplar);
                return; // Retorna sem adicionar se o código já existir
            }
        }

        Exemplar newExemplar = new Exemplar(codExemplar, estadoCon, disponibilidade, dataAquisicao);
        codExemplares.add(newExemplar);
        Exemplar.getExemplaresExistentes().add(newExemplar); 
        System.out.println("Exemplar adicionado com sucesso!");
    }
        public void removerExemplar(int exemplar){
            codExemplares.remove(exemplar);
        }



        //metodo para retornar livro
        public static void mostrarLivros(){
            for(Livros livros : colecaoLivros ){
                System.out.println("Código: " + livros.getCodLivro());
                System.out.println("Título: " + livros.getTitulo());
                System.out.println("Autor: " + livros.getAutor());
                System.out.println("Gênero: " + livros.getGenero());
                System.out.println("----------------------------------");
            }
        }

        public static void buscarLivro(){
            Scanner teclado = new Scanner(System.in);
            System.out.println("Digite o codigo do livro para busca");
            int codLivro = teclado.nextInt();


           for(Livros livros: colecaoLivros){
               if(livros.getCodLivro() == codLivro){
                System.out.println("------------------------------------------");

                System.out.println("Título: " + livros.getTitulo());
                System.out.println("Autor: " + livros.getAutor());
                System.out.println("Gênero: " + livros.getGenero());
                System.out.println("Editora: " + livros.getEditora());
                System.out.println("Ano de Publicação: " + livros.getAnoPublicacao());               
                   return;
               }
           }
            System.out.println("Livro com o codigo " + codLivro + " não encontrado.");
        }








        //Getter e Setters
        public int getCodLivro() {
            return codLivro;
        }

        public void setCodLivro(int codLivro) {
            this.codLivro = codLivro;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getEditora() {
            return editora;
        }

        public void setEditora(String editora) {
            this.editora = editora;
        }

        public int getAnoPublicacao() {
            return anoPublicacao;
        }

        public void setAnoPublicacao(int anoPublicacao) {
            this.anoPublicacao = anoPublicacao;
        }

        public ArrayList<Exemplar> getCodExemplares() {
            System.out.println("-------------------------------");
            for (Exemplar exemplar : this.codExemplares) {

                if(exemplar.getDisponibilidade() == "Disponivel"){
                     System.out.println("Codigo do exemplar: " + exemplar.getExemplar());
                }

            }
            System.out.println("--------------------------------");
            return this.codExemplares;

        }

        public void setCodExemplares(ArrayList<Exemplar> codExemplareres) {
            this.codExemplares = codExemplareres;
        }

        public static ArrayList<Livros> getColecaoLivros() {
            return colecaoLivros;
        }

        public static void setColecaoLivros(ArrayList<Livros> colecaoLivros) {
            Livros.colecaoLivros = colecaoLivros;
        }



    }
