package Publicacao;

import java.util.ArrayList;

public class Tese extends Publicacao{
    private int numeroPaginas;
    private String resumo;
    private String dataDefesa;
    private String instituicao;

    public Tese(String titulo, String dataPublicacao, ArrayList<Publicacao> referencias, ArrayList<Autor> autores, double multa, int numeroPaginas, String resumo, String dataDefesa, String instituicao) {
        super(titulo, dataPublicacao, referencias, autores, multa);
        this.numeroPaginas = numeroPaginas;
        this.resumo = resumo;
        this.dataDefesa = dataDefesa;
        this.instituicao = instituicao;
    }
    public Tese(String titulo, String dataPublicacao, ArrayList<Autor> autores, int numeroPaginas, String resumo, String dataDefesa, String instituicao) {
        super(titulo, dataPublicacao, autores);
        this.numeroPaginas = numeroPaginas;
        this.resumo = resumo;
        this.dataDefesa = dataDefesa;
        this.instituicao = instituicao;
    }
}
