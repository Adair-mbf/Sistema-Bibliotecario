import java.util.ArrayList;
import java.util.Scanner;

import Publicacao.Artigo;
import Publicacao.Autor;
import Publicacao.Livro;
import Publicacao.Publicacao;
import Publicacao.Tese;
import Servico.Emprestimo;
import Usuario.Usuario;
import Usuario.UsuarioEspecial;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Suap", "Rua faria lima, quadra 5 lote 3, Itumbiara");
        byte opcao;
        do{
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastrar publicacao");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Realizar empréstimo para o usuário");
            System.out.println("4 - Renovar empréstimo de usuário");
            System.out.println("5 - Devolver o empréstimo do usuário");
            System.out.println("0 - Sair");
            opcao = leitor.nextByte();
            leitor.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    System.out.println("Digite o título:");
                    String titulo = leitor.nextLine();
                    System.out.println("Digite a data de publicação:");
                    String dataPublicacao = leitor.nextLine();
                    System.out.println("Digite a quantidade de referencias:");
                    int qntdReferencia = leitor.nextInt();
                    leitor.nextLine();
                    ArrayList<Publicacao> referencias = new ArrayList<>();
                    for(int i = 0; i < qntdReferencia; i++){
                        System.out.println("A referência está presente na biblioteca?");
                        boolean presente = leitor.nextBoolean();
                        leitor.nextLine();
                        if(presente){
                            System.out.println("Digite o id da publicação:");
                            int id = leitor.nextInt();
                            leitor.nextLine();
                            Publicacao publicacao1 = biblioteca.buscarPublicacao(id);
                            if(publicacao1 != null){
                                referencias.add(publicacao1);
                            }
                            else{
                                i--;
                                continue;
                            }
                        }
                        else{
                            System.out.println("Digite o título da publicação:");
                            String tituloR = leitor.nextLine();
                            System.out.println("Digite a data de publicação:");
                            String dataPublicacaoR = leitor.nextLine();
                            System.out.println("Qual o tipo de publicação da referência?");
                            System.out.println("1 - Livro");
                            System.out.println("2 - Artigo");
                            System.out.println("3 - Tese");
                            byte tipoRef = leitor.nextByte();
                            leitor.nextLine();
                            switch (tipoRef) {
                                case 1:{
                                    ArrayList<Autor> autores1 = interacaoAutor(leitor);
                                    System.out.println("Digite a isbn:");
                                    String isbn = leitor.nextLine();
                                    System.out.println("Digite o nome da editora:");
                                    String editora = leitor.nextLine();
                                    System.out.println("Digite o número da edição:");
                                    int edicao = leitor.nextInt();
                                    leitor.nextLine();
                                    Livro livroR = new Livro(tituloR, dataPublicacaoR, autores1, isbn, editora, edicao);
                                    referencias.add(livroR);
                                    break;
                                }
                                case 2:{
                                    ArrayList<Autor> autores1 = interacaoAutor(leitor);
                                    System.out.println("Digite o resumo do artigo:");
                                    String resumoR = leitor.nextLine();
                                    Artigo artigoR = new Artigo(tituloR, dataPublicacaoR, autores1, resumoR);
                                    referencias.add(artigoR);
                                    break;
                                }
                                case 3:{
                                    System.out.println("Digite o nome do autor da tese:");
                                    String nomeT = leitor.nextLine();
                                    System.out.println("Digite a titulação do autor da Tese:");
                                    String titulacaoT = leitor.nextLine();
                                    Autor autorT = new Autor(nomeT, titulacaoT);
                                    ArrayList<Autor> autoresT = new ArrayList<>();
                                    autoresT.add(autorT);
                                    System.out.println("Digite o número de páginas da Tese:");
                                    int paginasT = leitor.nextInt();
                                    leitor.nextLine();
                                    System.out.println("Digite o resumo da Tese:");
                                    String resumoT = leitor.nextLine();
                                    System.out.println("Digite a data da defesa da Tese:");
                                    String dataT = leitor.nextLine();
                                    System.out.println("Digite o nome da instituição onde a Tese foi escrita:");
                                    String instituicaoT = leitor.nextLine();
                                    Tese teseR = new Tese(tituloR, dataPublicacaoR, autoresT, paginasT, resumoT, dataT, instituicaoT);
                                    referencias.add(teseR);
                                    break;
                                }
                            }
                        }
                    System.out.println("Digite o valor da multa:");
                    double multa = leitor.nextDouble();
                    leitor.nextLine();
                    byte tipoPub = tipoPub(leitor);
                    switch (tipoPub) {
                        case 1:{
                            System.out.println("Digite a isbn:");
                            String isbn = leitor.nextLine();
                            System.out.println("Digite o nome da editora:");
                            String editora = leitor.nextLine();
                            System.out.println("Digite o número da edição:");
                            int edicao = leitor.nextInt();
                            leitor.nextLine();
                            ArrayList<Autor> autores = interacaoAutor(leitor);   
                            Livro livro = new Livro(titulo, dataPublicacao, referencias, autores, multa, isbn, editora, edicao);
                            biblioteca.cadastrarPublicacao(livro);
                            break;
                        }
                        case 2:{
                            ArrayList<Autor> autores = interacaoAutor(leitor);
                            System.out.println("Digite o resumo:");
                            String resumo = leitor.nextLine();
                            Artigo artigo = new Artigo(titulo, dataPublicacao, referencias, autores, multa, resumo);
                            biblioteca.cadastrarPublicacao(artigo);
                            break;
                        }
                        case 3:{
                            ArrayList<Autor> autores = new ArrayList<>();
                            System.out.println("Digite o nome do autor:");
                            String nome = leitor.nextLine();
                            System.out.println("Digite a titulação do autor:");
                            String titulacao = leitor.nextLine();
                            Autor autor = new Autor(nome, titulacao);
                            autores.add(autor);
                            System.out.println("Digite o número de páginas:");
                            int numeroPaginas = leitor.nextInt();
                            leitor.nextLine();
                            System.out.println("Digite o resumo:");
                            String resumo = leitor.nextLine();
                            System.out.println("Digite a data da defesa da tese:");
                            String dataDefesa = leitor.nextLine();
                            System.out.println("Digite o nome da instituição da tese:");
                            String instituicao = leitor.nextLine();
                            Tese tese = new Tese(titulo, dataPublicacao, referencias, autores, multa, numeroPaginas, resumo, dataDefesa, instituicao);
                            biblioteca.cadastrarPublicacao(tese);
                            break;
                        }
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    break;
                }
                case 2:
                    System.out.println("Digite o nome do usuário:");
                    String nome = leitor.nextLine();
                    System.out.println("Digite o telefone do usuário:");
                    String telefone = leitor.nextLine();
                    System.out.println("Digite o email do usuário:");
                    String email = leitor.nextLine();
                    System.out.println("Digite o cpf do usuário:");
                    String cpf = leitor.nextLine();
                    System.out.println("Qual o tipo de usuário?");
                    System.out.println("1 - Usuário comum");
                    System.out.println("2 - Usuário especial");
                    byte tipoUsu = leitor.nextByte();
                    leitor.nextLine();
                    switch (tipoUsu) {
                        case 1:{
                            Usuario usuario = new Usuario(nome, telefone, email, cpf);
                            biblioteca.cadastrarUsuario(usuario);
                            break;
                        }
                        case 2:{
                            UsuarioEspecial usuario = new UsuarioEspecial(nome, telefone, email, cpf);
                            biblioteca.cadastrarUsuario(usuario);
                            break;
                        }
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                case 3:{
                    Usuario usuario = interacaoCpf(leitor, biblioteca);
                    if(usuario != null){
                        System.out.println("Digite o id da publicação:");
                        int id = leitor.nextInt();
                        leitor.nextLine();
                        Publicacao publicacao = biblioteca.buscarPublicacao(id);
                        usuario.solicitarEmprestimo(publicacao);
                    }
                    break;
                }
                case 4:{
                    Usuario usuario = interacaoCpf(leitor, biblioteca);
                    if(usuario != null){
                        if(usuario.getEmprestimos().isEmpty()){
                            System.out.println("O usuário não possui empréstimos ativos");
                        }
                        else{
                            System.out.println("Digite o id da publicação que deseja renovar:");
                            int id = leitor.nextInt();
                            leitor.nextLine();
                            Emprestimo emprestimo = usuario.buscarEmprestimos(id);
                            if(emprestimo != null){
                                emprestimo.renovar();
                            }
                        }
                    }
                    break;
                }
                case 5:{
                    Usuario usuario = interacaoCpf(leitor, biblioteca);
                    if(usuario != null){
                        if(usuario.getEmprestimos().isEmpty()){
                            System.out.println("O usuário não possui empréstimos ativos");
                        }
                        else{
                            System.out.println("Digite o id da publicação que deseja devolver:");
                            int id = leitor.nextInt();
                            leitor.nextLine();
                            Emprestimo emprestimo = usuario.buscarEmprestimos(id);
                            if (emprestimo != null) {
                                usuario.devolverEmprestimo(emprestimo);
                            }
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 0);

        leitor.close();
    }
    private static Usuario interacaoCpf(Scanner leitor, Biblioteca biblioteca){
        System.out.println("Digite o cpf do usuário:");
        String cpf = leitor.nextLine();
        return biblioteca.buscarUsuario(cpf);
    }
    private static byte tipoPub(Scanner leitor){
        System.out.println("Qual o tipo de publicação?");
        System.out.println("1 - Livro");
        System.out.println("2 - Artigo");
        System.out.println("3 - Tese");
        byte tipoPub = leitor.nextByte();
        leitor.nextLine();
        return tipoPub;
    }
    private static ArrayList<Autor> interacaoAutor(Scanner leitor){
        System.out.println("Digite a quantidade de autores:");
        int qntdAutores = leitor.nextInt();
        leitor.nextLine();
        ArrayList<Autor> autores1 = new ArrayList<>();
        for(int j = 0; j < qntdAutores; j++){
            System.out.println("Digite o nome do autor:");
            String nome = leitor.nextLine();
            System.out.println("Digite a titulação do autor");
            String titulacao = leitor.nextLine();
            Autor autor1 = new Autor(nome, titulacao);
            autores1.add(autor1);
        }
        return autores1;
    }
}
