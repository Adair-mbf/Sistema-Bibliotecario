package Publicacao;

import java.util.ArrayList;

public class Tese extends Publicacao{
    private int numeroPaginas;
    private String resumo;
    private String autor;
    private String dataDefesa;
    private String instituicao;

    public Tese(String titulo, String dataPublicacao, ArrayList<Publicacao> referencias, ArrayList<Autor> autores, int numeroPaginas, String resumo, String autor, String dataDefesa, String instituicao) {
        super(titulo, dataPublicacao, referencias, autores);
        this.numeroPaginas = numeroPaginas;
        this.resumo = resumo;
        this.autor = autor;
        this.dataDefesa = dataDefesa;
        this.instituicao = instituicao;
    }

    
}
