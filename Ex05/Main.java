import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("Toyota", "Corolla", 2020, "ABC1234"));
        carros.add(new Carro("Honda", "Civic", 2019, "DEF5678"));
        carros.add(new Carro("Ford", "Focus", 2018, "GHI9012"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um carro pelo índice:");
        for (int i = 0; i < carros.size(); i++) {
            System.out.println(i + ": " + carros.get(i).getMarca() + " " + carros.get(i).getModelo());
        }

        int indiceCarroEscolhido = scanner.nextInt();
        scanner.nextLine();

        Carro carroEscolhido = carros.get(indiceCarroEscolhido);

        System.out.println("\nEstado inicial do carro:");
        carroEscolhido.exibirInformacoes();

        System.out.println("\nDigite a quantidade para acelerar:");
        double quantidadeAcelerar = scanner.nextDouble();
        carroEscolhido.acelerar(quantidadeAcelerar);

        System.out.println("\nDepois de acelerar:");
        carroEscolhido.exibirInformacoes();

        System.out.println("\nDigite a quantidade para frear:");
        double quantidadeFrear = scanner.nextDouble();
        carroEscolhido.frear(quantidadeFrear);

        System.out.println("\nDepois de frear:");
        carroEscolhido.exibirInformacoes();

        scanner.close();
    }
}
