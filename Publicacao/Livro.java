package Publicacao;

import java.util.ArrayList;

public class Livro extends Publicacao{
    private String isbn;
    private String editora;
    private int edicao;

    public Livro(String titulo, String dataPublicacao, ArrayList<Publicacao> referencias, ArrayList<Autor> autores, double multa, String isbn, String editora, int edicao) {
        super(titulo, dataPublicacao, referencias, autores, multa);
        this.isbn = isbn;
        this.editora = editora;
        this.edicao = edicao;
    }
    public Livro(String titulo, String dataPublicacao, ArrayList<Autor> autores, String isbn, String editora, int edicao){
        super(titulo, dataPublicacao, autores);
        this.isbn = isbn;
        this.editora = editora;
        this.edicao = edicao;
    }
}
