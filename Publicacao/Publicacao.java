package Publicacao;

import java.util.ArrayList;

public abstract class Publicacao {
    private int id;
    private static int geradorId = 1000;
    private String titulo;
    private String dataPublicacao;
    private ArrayList<Publicacao> referencias;
    private ArrayList<Autor> autores;
    private double multa;

    public Publicacao(String titulo, String dataPublicacao, ArrayList<Publicacao> referencias, ArrayList<Autor> autores, double multa) {
        this.id = geradorId++;
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.referencias = referencias;
        this.autores = autores;
        this.multa = multa;
    }
    public Publicacao(String titulo, String dataPublicacao, ArrayList<Autor> autores) {
        this.id = geradorId++; // IMPORTANTE: mantém a contagem global correta
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.autores = autores;
        this.referencias = new ArrayList<>(); // Inicializa para evitar NullPointerException
        this.multa = 0.0;
    }
    public int getId() {
        return id;
    }
}