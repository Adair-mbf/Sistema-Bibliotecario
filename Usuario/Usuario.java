package Usuario;

import Publicacao.Publicacao;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private ArrayList<Publicacao> emprestimos;
    private int renovacoesEmprestimo;
    private double multa;

    
    public Usuario(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.emprestimos = new ArrayList<>();
        this.renovacoesEmprestimo = 0;
        this.multa = 0;
    }
    public String getCpf() {
        return cpf;
    }

    public void pagarMulta(){
        this.multa = 0;
    }
    public void solicitarEmprestimo(){
        
    }
    public void renovarEmprestimo(){
        renovacoesEmprestimo++;
        if (renovacoesEmprestimo > 3) {
            
        }
    }
}
