import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Buscar Contato");
            System.out.println("4. Exibir Contatos");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do contato:");
                    String nomeAdicionar = scanner.nextLine();
                    System.out.println("Digite o telefone do contato (formato: xxxxx-xxxx):");
                    String telefoneAdicionar = scanner.nextLine();
                    Contato novoContato = new Contato(nomeAdicionar, telefoneAdicionar);
                    agenda.adicionarContato(novoContato);
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o nome do contato que deseja remover:");
                    String nomeRemover = scanner.nextLine();
                    agenda.removerContato(nomeRemover);
                    break;
                case 3:
                    System.out.println("Digite o nome do contato que deseja buscar:");
                    String nomeBuscar = scanner.nextLine();
                    System.out.println("Contatos encontrados:");
                    agenda.buscarContato(nomeBuscar).forEach(System.out::println);
                    break;
                case 4:
                    agenda.exibirContatos();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }

        scanner.close();
    }
}
