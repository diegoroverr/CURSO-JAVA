public class main {
    public static void main(String[] args) {
        livro livro1 = new livro("Java: Do básico ao avançado", "João", 2020);
        livro livro2 = new livro("Python para iniciantes", "Pedro", 2018);
        livro livro3 = new livro("Lógica", "Maria", 2022);
        livro livro4 = new livro("Matrizes e Vetores", "Ana", 2024);

        System.out.println("Informações do Livro 1:");
        livro1.exibirinfo();

        System.out.println("Informações do Livro 2:");
        livro2.exibirinfo();

        System.out.println("Informações do Livro 3:");
        livro3.exibirinfo();

        System.out.println("Informações do Livro 4:");
        livro4.exibirinfo();
    }
}
