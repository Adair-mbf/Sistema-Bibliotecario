package Usuario;

import Publicacao.Publicacao;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    protected ArrayList<Publicacao> emprestimos;
    private int renovacoesEmprestimo;
    private double multa;

    
    public Usuario(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.emprestimos = new ArrayList<>();
        this.renovacoesEmprestimo = 0;
        this.multa = 0.0;
    }
    public String getCpf() {
        return cpf;
    }
    
    public ArrayList<Publicacao> getEmprestimos() {
        return emprestimos;
    }
    public void pagarMulta(){
        this.multa = 0;
    }
    public void solicitarEmprestimo(Publicacao publicacao){
        if(this.emprestimos.isEmpty()){
            this.emprestimos.add(publicacao);
            System.out.println("Empréstimo realizado!");
        }
    }
    public void renovarEmprestimo(Publicacao publicacao){
        this.renovacoesEmprestimo++;
        if (this.renovacoesEmprestimo > 3) {
            this.multa += publicacao.getMulta();
            System.out.println("Limite de renovações excedido!");
            System.out.println("Multa da publicação: " + publicacao.getMulta());
            System.out.println("O usuário está devendo R$" + this.multa + " para a biblioteca");
        }
    }
    public Publicacao buscarEmprestimos(int id){
        for(int i = 0; i < emprestimos.size(); i++){
            if(id == emprestimos.get(i).getId()){
                return emprestimos.get(i);
            }
        }
        System.out.println("Empréstimo não encontrado!");
        return null;
    }
}
