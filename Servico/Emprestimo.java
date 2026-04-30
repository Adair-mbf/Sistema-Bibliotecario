package Servico;
import Publicacao.Publicacao;
import Usuario.Usuario;

public class Emprestimo {
    private Usuario usuario;
    private Publicacao publicacao;
    private int renovacoes;

    public Emprestimo(Usuario usuario, Publicacao publicacao) {
        this.usuario = usuario;
        this.publicacao = publicacao;
        this.renovacoes = 0;
    }

    public void renovar(){
        this.renovacoes++;
        if(this.renovacoes > 3){
            double valorMulta = publicacao.getMulta();
            usuario.adicionarMulta(valorMulta);
            System.out.println("Limite de renovações excedido!");
            System.out.println("Multa da publicação: " + valorMulta);
            System.out.println("Sua multa: " + usuario.getMulta());
        }
    }

    public Publicacao getPublicacao(){
        return publicacao;
    }
}
