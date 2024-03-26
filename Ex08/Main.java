import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pizza> menu = new ArrayList<>();
        menu.add(new Pizza("Calabresa", 30.0, new String[]{"Molho de tomate", "Calabresa", "Cebola", "Mussarela"}));
        menu.add(new Pizza("Margherita", 35.0, new String[]{"Molho de tomate", "Mussarela", "Manjericão"}));
        menu.add(new Pizza("Frango com Catupiry", 35.0, new String[]{"Molho de tomate", "Frango", "Catupiry", "Mussarela"}));
        menu.add(new Pizza("Portuguesa", 30.0, new String[]{"Molho de tomate", "Presunto", "Mussarela", "Ovo", "Cebola", "Azeitona", "Pimentão"}));
        menu.add(new Pizza("Quatro Queijos", 35.0, new String[]{"Molho de tomate", "Mussarela", "Gorgonzola", "Provolone", "Parmesão"}));
        menu.add(new Pizza("Califórnia", 40.0, new String[]{"Molho de tomate", "Mussarela", "Presunto", "Mussarela", "Abacaxi", "Cereja"}));
        menu.add(new Pizza("Vegetariana", 35.0, new String[]{"Molho de tomate", "Mussarela", "Tomate", "Cebola", "Pimentão", "Azeitona", "Broto de bambu"}));
        menu.add(new Pizza("Pepperoni", 35.0, new String[]{"Molho de tomate", "Mussarela", "Pepperoni"}));
        menu.add(new Pizza("Especial da Casa", 40.0, new String[]{"Molho de tomate", "Mussarela", "Presunto", "Calabresa", "Milho", "Catupiry"}));
        menu.add(new Pizza("Frango com Cheddar", 40.0, new String[]{"Molho de tomate", "Mussarela", "Frango", "Cheddar"}));

        List<Pedido> pedidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean executando = true;
        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Pedido");
            System.out.println("2. Remover Pedido");
            System.out.println("3. Gerar Relatório de Pedidos");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o número da pizza desejada:");
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println((i + 1) + ". " + menu.get(i).getNome() + " - R$" + menu.get(i).getValor());
                    }
                    int escolhaPizza = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Escolha o tamanho da pizza (P - Pequena, M - Média, G - Grande):");
                    String tamanhoPizza = scanner.nextLine();

                    System.out.println("Digite o endereço de entrega:");
                    String endereco = scanner.nextLine();

                    Pizza pizzaEscolhida = menu.get(escolhaPizza - 1);
                    pedidos.add(new Pedido(pizzaEscolhida.getNome(), tamanhoPizza, pizzaEscolhida.getValor(), endereco));
                    System.out.println("Pedido adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o número do pedido que deseja remover:");
                    int numPedidoRemover = scanner.nextInt();
                    if (numPedidoRemover >= 1 && numPedidoRemover <= pedidos.size()) {
                        pedidos.remove(numPedidoRemover - 1);
                        System.out.println("Pedido removido com sucesso!");
                    } else {
                        System.out.println("Número de pedido inválido!");
                    }
                    break;
                case 3:
                    gerarRelatorio(pedidos);
                    break;
                case 4:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }

        scanner.close();
    }

    private static void gerarRelatorio(List<Pedido> pedidos) {
        System.out.println("Relatório de Pedidos:");
    if (pedidos.isEmpty()) {
        System.out.println("Não há pedidos registrados.");
    } else {
        double totalPedido = 0;
        for (Pedido pedido : pedidos) {
            System.out.println("Tipo da Pizza: " + pedido.getTipoPizza());
            System.out.println("Tamanho: " + pedido.getTamanho());
            System.out.println("Valor: R$" + pedido.getValor());
            System.out.println("Endereço de Entrega: " + pedido.getEnderecoEntrega());
            System.out.println("------------------------------------");
            totalPedido += pedido.getValor();
        }
        System.out.println("Número total de pedidos: " + pedidos.size());
        System.out.println("Média de preço dos pedidos: R$" + (totalPedido / pedidos.size()));
    }
}
}
