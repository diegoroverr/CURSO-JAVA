import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Jogadores!");

        Jogador jogador1 = new Jogador("Goblin", 0, 1);
        Jogador jogador2 = new Jogador("Mago", 5, 2);
        Jogador jogador3 = new Jogador("Boss", 10, 7);

        int opcao;
        do {
            System.out.println("\nEscolha um jogador:");
            System.out.println("1. " + jogador1.getNome());
            System.out.println("2. " + jogador2.getNome());
            System.out.println("3. " + jogador3.getNome());
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarJogador(jogador1);
                    break;
                case 2:
                    gerenciarJogador(jogador2);
                    break;
                case 3:
                    gerenciarJogador(jogador3);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void gerenciarJogador(Jogador jogador) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nEscolha uma opção para " + jogador.getNome() + ":");
            System.out.println("1. Exibir informações do jogador");
            System.out.println("2. Aumentar pontuação");
            System.out.println("3. Subir de nível");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    jogador.exibirInformacoes();
                    break;
                case 2:
                    System.out.print("Informe a quantidade de pontuação a ser adicionada: ");
                    int pontuacao = scanner.nextInt();
                    jogador.aumentarPontuacao(pontuacao);
                    break;
                case 3:
                    jogador.subirNivel();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}
