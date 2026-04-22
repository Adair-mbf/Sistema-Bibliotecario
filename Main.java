import java.util.ArrayList;
import java.util.Scanner;

import Publicacao.Autor;
import Publicacao.Livro;
import Publicacao.Publicacao;
import Usuario.Usuario;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Suap", "Rua faria lima, quadra 5 lote 3, Itumbiara");
        byte opcao;
        do{
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastrar publicacao");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Renovar empréstimo de usuário");
            System.out.println("0 - Sair");
            opcao = leitor.nextByte();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    System.out.println("Qual o tipo de publicação?");
                    System.out.println("1 - Livro");
                    System.out.println("2 - Artigo");
                    System.out.println("3 - Tese");
                    byte tipoPub = leitor.nextByte();
                    switch (tipoPub) {
                        case 1:{
                            System.out.println("Digite o título:");
                            String titulo = leitor.nextLine();
                            System.out.println("Digite a data de publicação:");
                            String dataPublicacao = leitor.nextLine();
                            System.out.println("Digite a quantidade de referencias:");
                            int qntdReferencia = leitor.nextInt();
                            ArrayList<Publicacao> referencias = new ArrayList<>();
                            for(int i = 0; i < qntdReferencia; i++){
                                System.out.println("A referência está presente na biblioteca?");
                                boolean presente = leitor.nextBoolean();
                                if(presente){
                                    System.out.println("Digite o id da publicação:");
                                    int id = leitor.nextInt();
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
                                    System.out.println("Qual o tipo da referência?");
                                    System.out.println("1 - Livro");
                                    System.out.println("2 - Artigo");
                                    System.out.println("3 - Tese");
                                    byte tipoRef = leitor.nextByte();
                                    switch (tipoRef) {
                                        case 1:{
                                            System.out.println("Digite o título do livro:");
                                            String tituloR = leitor.nextLine();
                                            System.out.println("Digite a data da publicação do livro:");
                                            String dataPublicacaoR = leitor.nextLine();
                                            System.out.println("Digite a quantidade de autores:");
                                            int qntdAutores = leitor.nextInt();
                                            ArrayList<Autor> autores1 = new ArrayList<>();
                                            for(int j = 0; i < qntdAutores; j++){
                                                System.out.println("Digite o nome do autor:");
                                                String nome = leitor.nextLine();
                                                System.out.println("Digite a titulação do autor");
                                                String titulacao = leitor.nextLine();
                                                Autor autor1 = new Autor(nome, titulacao);
                                                autores1.add(autor1);
                                            }
                                            System.out.println("Digite a isbn:");
                                            String isbn = leitor.nextLine();
                                            System.out.println("Digite o nome da editora:");
                                            String editora = leitor.nextLine();
                                            System.out.println("Digite o número da edição:");
                                            int edicao = leitor.nextInt();
                                            Livro livroR = new Livro(tituloR, dataPublicacaoR, null, autores1, isbn, editora, edicao);
                                            referencias.add(livroR);
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Digite o título do artigo:");
                                            String tituloR = leitor.nextLine();
                                            System.out.println("Digite a data de publicação do artigo:");
                                            String dataPublicacaoR = leitor.nextLine();
                                            System.out.println("Digite a quantidade de autores:");
                                            int qntdAutores = leitor.nextInt();
                                            ArrayList<Autor> autores1 = new ArrayList<>();
                                            for(int j = 0; j < qntdAutores; j++){
                                                System.out.println("Digite o nome do autor:");
                                                String nome = leitor.nextLine();
                                                System.out.println("Digite a titulação do autor");
                                                String titulacao = leitor.nextLine();
                                                Autor autor1 = new Autor(nome, titulacao);
                                                autores1.add(autor1);
                                            }
                                            System.out.println("Digite o resumo do artigo:");
                                            String resumoR = leitor.nextLine();
                                            break;
                                        }
                                        case 3:

                                            break;
                                        default:
                                            System.out.println("Opção inválida!");
                                            i--;
                                            continue;
                                    }
                                }
                            }
                            System.out.println("Digite o valor da multa:");
                            double multa = leitor.nextDouble();
                            System.out.println("Digite a isbn:");
                            String isbn = leitor.nextLine();
                            System.out.println("Digite o nome da editora:");
                            String editora = leitor.nextLine();
                            System.out.println("Digite o número da edição:");
                            int edicao = leitor.nextInt();
                            ArrayList<Autor> autores = new ArrayList<>();
                            System.out.println("Digite a quantidade de autores:");
                            int qntautores = leitor.nextInt();
                            for(int i = 0; i < qntautores; i++){
                                System.out.println("Digite o nome do autor:");
                                String nome = leitor.nextLine();
                                System.out.println("Digite a titulação do autor");
                                String titulacao = leitor.nextLine();
                                Autor autor = new Autor(nome, titulacao);
                                autores.add(autor);
                            }
                            Livro livro = new Livro(titulo, dataPublicacao, referencias, autores, isbn, editora, edicao);
                            biblioteca.cadastrarPublicacao(livro);
                            break;
                        }
                        case 2:

                            break;
                        case 3:

                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Qual o tipo de usuário?");
                    System.out.println("1 - Usuário comum");
                    System.out.println("2 - Usuário especial");
                    byte tipoUsu = leitor.nextByte();
                    switch (tipoUsu) {
                        case 1:{
                            System.out.println("Digite o nome do usuário:");
                            String nome = leitor.nextLine();
                            System.out.println("Digite o telefone do usuário:");
                            String telefone = leitor.nextLine();
                            System.out.println("Digite o email do usuário:");
                            String email = leitor.nextLine();
                            System.out.println("Digite o cpf do usuário:");
                            String cpf = leitor.nextLine();
                            Usuario usuario = new Usuario(nome, telefone, email, cpf);
                            biblioteca.cadastrarUsuario(usuario);
                            break;
                        }
                        case 2:

                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                case 3:{
                    System.out.println("Digite o cpf do usuário");
                    String cpf = leitor.nextLine();
                    Usuario usuario = biblioteca.buscarUsuario(cpf);
                    if(usuario != null){
                        
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
}
