import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Insira o primeiro número: ");
        int num1 = leitor.nextInt();

        System.out.print("Insira o segundo número: ");
        int num2 = leitor.nextInt();

        System.out.println("Escolha a operação:");
        System.out.println("DIGITE 1 PARA SOMA");
        System.out.println("DIGITE 2 PARA SUBTRAÇÃO");
        System.out.println("DIGITE 3 PARA MULTIPLICAÇÃO");
        System.out.println("DIGITE 4 PARA DIVISÃO");
        int oper = leitor.nextInt();

        int resolucao = 0;
        switch (oper) {
            case 1:
                resolucao = Calculadora.soma(num1, num2);
                break;
            case 2:
                resolucao = Calculadora.subtracao(num1, num2);
                break;
            case 3:
                resolucao = Calculadora.multiplicacao(num1, num2);
                break;
            case 4:
                try {
                    resolucao = Calculadora.divisao(num1, num2);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("Erro!");
                return;
        }

        System.out.printf("Resultado: %d", resolucao);

        
    }
}
