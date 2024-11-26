/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Usuario extends Pessoa {
    private int IdUsuario;
    private int limiteEmprestimos = 5;
    private String Email;
    private String DataCadastro;
    private static ArrayList<Usuario> listaUsuario = new ArrayList<>();
    private ArrayList<Integer> livrosEmprestados = new ArrayList<>(); // IDs dos exemplares emprestados

    public Usuario(String nomeCompleto, String dataNasc, String endereco, int telefone, String DataCadastro) {
        super(nomeCompleto, dataNasc, endereco, telefone);
        this.IdUsuario = (int) (Math.random() * 9000) + 1000;
        this.Email = this.IdUsuario + "@biblioteca.com";
        this.DataCadastro = DataCadastro;
        listaUsuario.add(this);
        
        System.out.println("Usuário criado com sucesso!");
        System.out.println("ID do Usuário: " + this.IdUsuario);
        System.out.println("Nome Completo: " + this.getNomeCompleto());
        System.out.println("Data de Nascimento: " + this.getDataNasc());
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("Email: " + this.Email);
        System.out.println("Data de Cadastro: " + this.DataCadastro);
        System.out.println("Limite de Empréstimos: " + this.limiteEmprestimos);
        System.out.println("----------------------------------");
        
    }

    @Override
    public String toString() {
        return "Usuario{" + "IdUsuario=" + IdUsuario + ", Email=" + Email + ", DataCadastro=" + DataCadastro + ", LivrosEmprestados=" + livrosEmprestados + '}';
    }

    public static void mostrarUsuario() {
        for (Usuario usuarios : listaUsuario) {
            System.out.println("Numero de Cadastro: " + usuarios.getIdUsuario());
            System.out.println("Nome: " + usuarios.getNomeCompleto());
            System.out.println("Data de Cadastro: " + usuarios.getDataCadastro());
            System.out.println("------------------------------------------");
        }
    }

    public static void buscarUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o codigo do Usuario");
        int idUsuario = teclado.nextInt();

        for (Usuario usuario : listaUsuario) {
            if (usuario.getIdUsuario() == idUsuario) {
                System.out.println("Número de Cadastro: " + usuario.getIdUsuario());
                System.out.println("Nome: " + usuario.getNomeCompleto());
                System.out.println("Data de Cadastro: " + usuario.getDataCadastro());
                System.out.println("Email: " + usuario.getEmail());
                System.out.println("------------------------------------------");
                return;
            }
        }
        System.out.println("Usuário com o ID " + idUsuario + " não encontrado.");
    }

    // Método para registrar um empréstimo
    public void realizarEmprestimo() {
        
        if (contarEmprestimosAtivos() >= limiteEmprestimos) {
            System.out.println("Você atingiu o limite de empréstimos ativos (" + limiteEmprestimos + ").");
            return;
        }
        
        Scanner teclado = new Scanner(System.in);

        // Solicita e valida o código do usuário
        System.out.println("Digite o seu código de usuário:");
        int codigoUsuario = teclado.nextInt();
        if (codigoUsuario != this.IdUsuario) {
            System.out.println("Código de usuário inválido.");
            return;
        }

        // Solicita e valida o código do exemplar
        System.out.println("Digite o código do exemplar para emprestar:");
        int codigoExemplar = teclado.nextInt();
        Exemplar exemplar = null;
        for (Exemplar myexemplar : Exemplar.getExemplaresExistentes()) {
            if (myexemplar.getExemplar() == codigoExemplar) {
                exemplar = myexemplar;
                break;
            }
        }
        if (exemplar == null || !exemplar.getDisponibilidade().equals("Disponivel")) {
            System.out.println("Empréstimo não realizado. Exemplar indisponível ou inexistente.");
            return;
        }

        // Define a data de empréstimo como a data atual
        Date dataEmprestimo = new Date();
        exemplar.setDataEmprestimo(dataEmprestimo);

        // Calcula e define a data de devolução prevista (15 dias após a data de empréstimo)
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataEmprestimo);
        cal.add(Calendar.DAY_OF_MONTH, 15);
        Date dataDevolucaoPrevista = cal.getTime();
        exemplar.setDataDevolucaoPrevista(dataDevolucaoPrevista);
        
        // Atualiza o status do exemplar e adiciona o empréstimo ao usuário
        exemplar.setDisponibilidade("Emprestado");
        livrosEmprestados.add(codigoExemplar);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Empréstimo realizado com sucesso para o exemplar " + codigoExemplar);
        System.out.println("Data de devolução prevista: " + sdf.format(dataDevolucaoPrevista));
    }

    // Método para registrar a devolução de um exemplar
    public void registrarDevolucao() {
        Scanner teclado = new Scanner(System.in);

        // Solicita e valida o código do exemplar para devolução
        System.out.println("Digite o código do exemplar para devolução:");
        int codigoExemplar = teclado.nextInt();
        Exemplar exemplar = null;
        for (Exemplar myexemplar : Exemplar.getExemplaresExistentes()) {
            if (myexemplar.getExemplar() == codigoExemplar) {
                exemplar = myexemplar;
                break;
            }
        }
        if (exemplar == null || !livrosEmprestados.contains(codigoExemplar)) {
            System.out.println("Devolução não realizada. Exemplar não consta nos empréstimos do usuário.");
            return;
        }

        // Solicita e valida a data de devolução
        System.out.println("Digite a data de devolução (dd/MM/yyyy):");
        teclado.nextLine();  // Consome a nova linha
        String dataDevolucaoStr = teclado.nextLine();
        Date dataDevolucao;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataDevolucao = sdf.parse(dataDevolucaoStr);

            // Verifica se a data de devolução é válida
            if (dataDevolucao.before(exemplar.getDataEmprestimo())) {
                System.out.println("Data de devolução inválida: não pode ser anterior à data de empréstimo.");
                return;
            }

            // Verifica se a devolução está atrasada
            if (dataDevolucao.after(exemplar.getDataDevolucaoPrevista())) {
                System.out.println("Devolução atrasada! Uma multa de R$5,00 será cobrada.");
            }

            exemplar.setDisponibilidade("Disponivel"); // Atualiza o status para disponível
            livrosEmprestados.remove((Integer) codigoExemplar);
            System.out.println("Devolução registrada para o exemplar " + codigoExemplar);
            System.out.println("Data de devolução registrada: " + sdf.format(dataDevolucao));
        } catch (Exception e) {
            System.out.println("Data de devolução inválida.");
        }
    }
    
    public int contarEmprestimosAtivos() {
        return livrosEmprestados.size();
    }

    // Método para listar os exemplares emprestados pelo usuário
    public void listarExemplaresEmprestados() {
        System.out.println("Exemplares atualmente emprestados pelo usuário " + this.IdUsuario + ":");
        for (int exemplarId : livrosEmprestados) {
            System.out.println("Código do Exemplar: " + exemplarId);
        }
        System.out.println("Total de exemplares emprestados: " + contarEmprestimosAtivos());
    }

    // Getters e Setters
    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(String DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public static ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public static void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        Usuario.listaUsuario = listaUsuario;
    }

    public ArrayList<Integer> getLivrosEmprestados() {
        return livrosEmprestados;
    }
}
