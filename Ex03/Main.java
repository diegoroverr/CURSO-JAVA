import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Sistema Bancário!");

        List<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaBancaria("João", 123456, 1000.0));
        contas.add(new ContaBancaria("Maria", 789012, 1500.0));
        contas.add(new ContaBancaria("Carlos", 345678, 2000.0));

        int opcaoConta;
        do {
            System.out.println("\nEscolha uma conta:");
            for (int i = 0; i < contas.size(); i++) {
                System.out.println((i + 1) + ". Conta de " + contas.get(i).getNomeCliente() + " - Saldo: " + contas.get(i).getSaldo());
            }
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcaoConta = scanner.nextInt();

            if (opcaoConta >= 1 && opcaoConta <= contas.size()) {
                operarConta(contas.get(opcaoConta - 1));
            } else if (opcaoConta != 0) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoConta != 0);
    }

    public static void operarConta(ContaBancaria conta) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
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
