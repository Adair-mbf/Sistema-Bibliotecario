package Usuario;

import Publicacao.Publicacao;
import Servico.Emprestimo;

public class UsuarioEspecial extends Usuario{
    
    public UsuarioEspecial(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
    }
    @Override
    public void solicitarEmprestimo(Publicacao publicacao){
        Emprestimo emprestimo = new Emprestimo(this, publicacao);
        getEmprestimos().add(emprestimo);
        publicacao.setDisponibilidade(false);
        System.out.println("Empréstimo realizado!");
    }
    @Override
    public void devolverEmprestimo(Emprestimo emprestimo){
        getEmprestimos().remove(emprestimo);
        emprestimo.getPublicacao().setDisponibilidade(true);
        System.out.println("Devolução realizada!");
    }
}
