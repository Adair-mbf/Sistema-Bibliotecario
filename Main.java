import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        byte opcao;
        do{
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Registrar publicacao");
            System.out.println("2 - Registrar usuário");
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
                        case 1:
                            
                            break;
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
                        case 1:
                            
                            break;
                        case 2:

                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 0);
    }
}
