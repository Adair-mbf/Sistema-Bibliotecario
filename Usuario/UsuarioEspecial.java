package Usuario;

import Publicacao.Publicacao;
import Servico.Emprestimo;

public class UsuarioEspecial extends Usuario{
    
    public UsuarioEspecial(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
    }
    @Override
    public void solicitarEmprestimo(Publicacao publicacao){
        if(publicacao.isDisponibilidade()){
            Emprestimo emprestimo = new Emprestimo(this, publicacao);
            getEmprestimos().add(emprestimo);
            publicacao.setDisponibilidade(false);
            System.out.println("Empréstimo realizado!");
        }
        else{
            System.out.println("Publicação indisponível!");
        }
    }
}
