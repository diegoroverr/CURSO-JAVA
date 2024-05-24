import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ContaCorrente contaCorrente = null;
        ContaPoupanca contaPoupanca = null;

        while (true) {
            System.out.println("\n=== Sistema de Gerenciamento de Finanças Pessoais ===");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Adicionar Transação");
            System.out.println("4. Visualizar Transações");
            System.out.println("5. Editar Transação");
            System.out.println("6. Excluir Transação");
            System.out.println("7. Gerar Relatório Financeiro");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    contaCorrente = criarContaCorrente();
                    break;
                case 2:
                    contaPoupanca = criarContaPoupanca();
                    break;
                case 3:
                    adicionarTransacao(contaCorrente, contaPoupanca);
                    break;
                case 4:
                    visualizarTransacoes(contaCorrente, contaPoupanca);
                    break;
                case 5:
                    editarTransacao(contaCorrente, contaPoupanca);
                    break;
                case 6:
                    excluirTransacao(contaCorrente, contaPoupanca);
                    break;
                case 7:
                    gerarRelatorio(contaCorrente, contaPoupanca);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static ContaCorrente criarContaCorrente() {
        System.out.print("Digite o número da conta corrente: ");
        String numero = scanner.nextLine();
        System.out.print("Digite a taxa de juros: ");
        double taxaJuros = scanner.nextDouble();
        System.out.print("Digite o limite do cheque especial: ");
        double limiteChequeEspecial = scanner.nextDouble();
        scanner.nextLine(); 

        return new ContaCorrente(numero, taxaJuros, limiteChequeEspecial);
    }

    private static ContaPoupanca criarContaPoupanca() {
        System.out.print("Digite o número da conta poupança: ");
        String numero = scanner.nextLine();
        System.out.print("Digite a taxa de rendimento: ");
        double taxaRendimento = scanner.nextDouble();
        System.out.print("Digite a data de aniversário: ");
        scanner.nextLine(); 
        String dataAniversario = scanner.nextLine();

        return new ContaPoupanca(numero, taxaRendimento, dataAniversario);
    }

    private static void adicionarTransacao(ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        if (contaCorrente == null && contaPoupanca == null) {
            System.out.println("Nenhuma conta criada.");
            return;
        }

        System.out.print("Digite o tipo de conta (corrente/poupanca): ");
        String tipoConta = scanner.nextLine();
        System.out.print("Digite a descrição da transação: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o valor da transação: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Digite o tipo de transação (receita/despesa): ");
        String tipoTransacao = scanner.nextLine();

        Transacao transacao = new Transacao(descricao, valor, tipoTransacao);
        if (tipoConta.equalsIgnoreCase("corrente") && contaCorrente != null) {
            if (tipoTransacao.equalsIgnoreCase("receita")) {
                contaCorrente.depositar(valor);
            } else {
                contaCorrente.sacar(valor);
            }
            contaCorrente.getTransacoes().add(transacao);
        } else if (tipoConta.equalsIgnoreCase("poupanca") && contaPoupanca != null) {
            if (tipoTransacao.equalsIgnoreCase("receita")) {
                contaPoupanca.depositar(valor);
            } else {
                contaPoupanca.sacar(valor);
            }
            contaPoupanca.getTransacoes().add(transacao);
        } else {
            System.out.println("Tipo de conta ou conta não encontrada.");
        }
    }

    private static void visualizarTransacoes(ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        if (contaCorrente != null) {
            System.out.println("\nTransações da Conta Corrente:");
            for (Transacao transacao : contaCorrente.getTransacoes()) {
                System.out.println(transacao.getData() + " - " + transacao.getDescricao() + ": " + transacao.getValor() + " (" + transacao.getTipo() + ")");
            }
        }
        if (contaPoupanca != null) {
            System.out.println("\nTransações da Conta Poupança:");
            for (Transacao transacao : contaPoupanca.getTransacoes()) {
                System.out.println(transacao.getData() + " - " + transacao.getDescricao() + ": " + transacao.getValor() + " (" + transacao.getTipo() + ")");
            }
        }
    }

    private static void editarTransacao(ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        System.out.print("Digite o tipo de conta (corrente/poupanca): ");
        String tipoConta = scanner.nextLine();
        System.out.print("Digite o índice da transação a ser editada: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite a nova descrição da transação: ");
        String novaDescricao = scanner.nextLine();
        System.out.print("Digite o novo valor da transação: ");
        double novoValor = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Digite o novo tipo de transação (receita/despesa): ");
        String novoTipo = scanner.nextLine();

        if (tipoConta.equalsIgnoreCase("corrente") && contaCorrente != null) {
            contaCorrente.editarTransacao(indice, novaDescricao, novoValor, novoTipo);
        } else if (tipoConta.equalsIgnoreCase("poupanca") && contaPoupanca != null) {
            contaPoupanca.editarTransacao(indice, novaDescricao, novoValor, novoTipo);
        } else {
            System.out.println("Tipo de conta ou conta não encontrada.");
        }
    }

    private static void excluirTransacao(ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        System.out.print("Digite o tipo de conta (corrente/poupanca): ");
        String tipoConta = scanner.nextLine();
        System.out.print("Digite o índice da transação a ser excluída: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); 

        if (tipoConta.equalsIgnoreCase("corrente") && contaCorrente != null) {
            contaCorrente.excluirTransacao(indice);
        } else if (tipoConta.equalsIgnoreCase("poupanca") && contaPoupanca != null) {
            contaPoupanca.excluirTransacao(indice);
        } else {
            System.out.println("Tipo de conta ou conta não encontrada.");
        }
    }

    private static void gerarRelatorio(ContaCorrente contaCorrente, ContaPoupanca contaPoupanca) {
        RelatorioFinanceiro relatorio = new RelatorioFinanceiro();
        if (contaCorrente != null) {
            System.out.println("\nRelatório Financeiro - Conta Corrente:");
            relatorio.gerarRelatorio(contaCorrente);
        }
        if (contaPoupanca != null) {
            System.out.println("\nRelatório Financeiro - Conta Poupança:");
            relatorio.gerarRelatorio(contaPoupanca);
        }
    }
}
