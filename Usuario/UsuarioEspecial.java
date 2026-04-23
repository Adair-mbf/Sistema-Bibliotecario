package Usuario;

import Publicacao.Publicacao;

public class UsuarioEspecial extends Usuario{
    
    public UsuarioEspecial(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
    }
    @Override
    public void solicitarEmprestimo(Publicacao publicacao){
        this.emprestimos.add(publicacao);
        publicacao.setDisponibilidade(false);
        System.out.println("Empréstimo realizado!");
    }
    @Override
    public void devolverEmprestimo(Publicacao publicacao){
        this.emprestimos.remove(publicacao);
        publicacao.setDisponibilidade(true);
        if(this.emprestimos.isEmpty()){
            setRenovacoesEmprestimo(0);
        }
    }
}
