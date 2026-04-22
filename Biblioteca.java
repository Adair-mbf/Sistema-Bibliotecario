import java.util.ArrayList;

import Publicacao.Publicacao;
import Usuario.Usuario;

public class Biblioteca {
    private String nome;
    private String endereco;
    private ArrayList<Publicacao> publicacoes;
    private ArrayList<Usuario> usuarios;
    
    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.publicacoes = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }
    public void cadastrarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }
    public void cadastrarPublicacao(Publicacao publicacao){
        this.publicacoes.add(publicacao);
        System.out.println("Publicação cadastrada com sucesso!");
    }
    public Usuario buscarUsuario(String cpf){
        for(int i = 0; i < usuarios.size(); i++){
            if(cpf.equals(usuarios.get(i).getCpf())){
                return usuarios.get(i);
            }
        }
        System.out.println("Usuário não encontrado!");
        return null;
    }
    public Publicacao buscarPublicacao(int id){
        for(int i = 0; i < publicacoes.size(); i++){
            if(id == publicacoes.get(i).getId()){
                return publicacoes.get(i);
            }
        }
        System.out.println("Publicação não encontrada!");
        return null;
    }
}
