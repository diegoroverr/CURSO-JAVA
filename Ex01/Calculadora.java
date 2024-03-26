public class Calculadora {
    public static int soma(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtracao(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiplicacao(int num1, int num2) {
        return num1 * num2;
    }

    public static int divisao(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Erro: Divisão por zero!");
        }
        return num1 / num2;
    }
}
