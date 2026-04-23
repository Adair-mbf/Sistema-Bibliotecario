package Publicacao;

import java.util.ArrayList;

public class Artigo extends Publicacao{
    private String resumo;

    public Artigo(String titulo, String dataPublicacao, ArrayList<Publicacao> referencias, ArrayList<Autor> autores, double multa, String resumo) {
        super(titulo, dataPublicacao, referencias, autores, multa);
        this.resumo = resumo;
    }
    public Artigo(String titulo, String dataPublicacao, ArrayList<Autor> autores, String resumo) {
        super(titulo, dataPublicacao, autores);
        this.resumo = resumo;
    }
}
