package Usuario;

import Publicacao.Publicacao;
import Servico.Emprestimo;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private ArrayList<Emprestimo> emprestimos;
    private int renovacoesEmprestimo;
    private double multa;

    
    public Usuario(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.emprestimos = new ArrayList<>();
        this.multa = 0.0;
    }
    public String getCpf() {
        return cpf;
    }
    
    public double getMulta() {
        return multa;
    }
    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    public void pagarMulta(){
        this.multa = 0;
    }
    public void adicionarMulta(double valor) {
        this.multa += valor;
    }
    public void solicitarEmprestimo(Publicacao publicacao){
        if(this.emprestimos.isEmpty()){
            Emprestimo emprestimo = new Emprestimo(this, publicacao);
            this.emprestimos.add(emprestimo);
            System.out.println("Empréstimo realizado!");
            publicacao.setDisponibilidade(false);
        }
    }
    public Emprestimo buscarEmprestimos(int id){
        for(int i = 0; i < this.emprestimos.size(); i++){
            if(id == emprestimos.get(i).getPublicacao().getId()){
                return emprestimos.get(i);
            }
        }
        System.out.println("Empréstimo não encontrado!");
        return null;
    }
    public void devolverEmprestimo(Emprestimo emprestimo){
        this.emprestimos.remove(emprestimo);
        emprestimo.getPublicacao().setDisponibilidade(true);
    }
    public void setRenovacoesEmprestimo(int renovacoesEmprestimo) {
        this.renovacoesEmprestimo = renovacoesEmprestimo;
    }
    
}
