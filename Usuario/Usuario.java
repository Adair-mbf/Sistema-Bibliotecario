package Usuario;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private ArrayList<Publicacao> emprestimos;
    private static int renovacoesEmprestimo;
    private static double multa;

    
    public Usuario(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }
    public void pagarMulta(){
        
    }
    public void solicitarEmprestimo(){

    }
    public void renovarEmprestimo(){
        renovacoesEmprestimo++;
        if (renovacoesEmprestimo > 3) {
            
        }
    }
}
