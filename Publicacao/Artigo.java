package Publicacao;

import java.util.ArrayList;

public class Artigo extends Publicacao{
    private String resumo;

    public Artigo(String titulo, String dataPublicacao, ArrayList<Publicacao> referencias, ArrayList<Autor> autores, String resumo) {
        super(titulo, dataPublicacao, referencias, autores);
        this.resumo = resumo;
    }

    
}
