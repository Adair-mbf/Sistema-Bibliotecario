package Usuario;

import Publicacao.Publicacao;

public class UsuarioEspecial extends Usuario{
    
    public UsuarioEspecial(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
    }
    @Override
    public void solicitarEmprestimo(Publicacao publicacao){
        this.emprestimos.add(publicacao);
        System.out.println("Empréstimo realizado!");
    }
}
