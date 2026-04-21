package Publicacao;

import java.util.ArrayList;

public abstract class Publicacao {
    private String titulo;
    private String dataPublicacao;
    private ArrayList<Publicacao> referencias;
    private ArrayList<Autor> autores;
    private double multa;

    public Publicacao(String titulo, String dataPublicacao, ArrayList<Publicacao> referencias, ArrayList<Autor> autores, double multa) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.referencias = referencias;
        this.autores = autores;
        this.multa = multa;
    }

}