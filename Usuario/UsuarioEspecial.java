package Usuario;

import Publicacao.Publicacao;

public class UsuarioEspecial extends Usuario{
    
    public UsuarioEspecial(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
    }
    @Override
    public void solicitarEmprestimo(Publicacao publicacao){
        getEmprestimos().add(publicacao);
        publicacao.setDisponibilidade(false);
        System.out.println("Empréstimo realizado!");
    }
    @Override
    public void devolverEmprestimo(Publicacao publicacao){
        getEmprestimos().remove(publicacao);
        publicacao.setDisponibilidade(true);
        if(getEmprestimos().isEmpty()){
            setRenovacoesEmprestimo(0);
        }
    }
}
