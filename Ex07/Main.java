import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> estoque = new ArrayList<>();

        boolean executando = true;
        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Gerar Relatório de Estoque");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o código do produto:");
                    int codigo = scanner.nextInt();
                    System.out.println("Digite o preço do produto:");
                    double preco = scanner.nextDouble();
                    System.out.println("Digite a quantidade em estoque:");
                    int quantidade = scanner.nextInt();

                    Produto novoProduto = new Produto(nome, codigo, preco, quantidade);
                    estoque.add(novoProduto);
                    break;
                case 2:
                    System.out.println("Digite o código do produto que deseja atualizar:");
                    int codigoAtualizar = scanner.nextInt();
                    Produto produtoAtualizar = encontrarProdutoPorCodigo(estoque, codigoAtualizar);
                    if (produtoAtualizar != null) {
                        System.out.println("Digite a quantidade a ser adicionada (use número negativo para remover):");
                        int quantidadeAtualizar = scanner.nextInt();
                        produtoAtualizar.atualizarEstoque(quantidadeAtualizar);
                        System.out.println("Estoque atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 3:
                    System.out.println("Digite o código do produto que deseja remover:");
                    int codigoRemover = scanner.nextInt();
                    Produto produtoRemover = encontrarProdutoPorCodigo(estoque, codigoRemover);
                    if (produtoRemover != null) {
                        estoque.remove(produtoRemover);
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("Relatório de Estoque:");
                    for (Produto produto : estoque) {
                        produto.exibirInformacoes();
                        System.out.println("-----------------------------");
                    }
                    break;
                case 5:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }

        scanner.close();
    }

    
    private static Produto encontrarProdutoPorCodigo(List<Produto> estoque, int codigo) {
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }
}
