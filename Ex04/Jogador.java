public class Jogador {
    private String nome;
    private int pontuacao;
    private int nivel;

    public Jogador(String nome, int pontuacaoInicial, int nivelInicial) {
        this.nome = nome;
        this.pontuacao = pontuacaoInicial;
        this.nivel = nivelInicial;
    }

    public void aumentarPontuacao(int valor) {
        if (valor > 0) {
            pontuacao += valor;
            System.out.println("Pontuação aumentada em " + valor + ".");
        } else {
            System.out.println("A pontuação deve ser um valor positivo.");
        }
    }

    public void subirNivel() {
        nivel++;
        System.out.println("O jogador " + nome + " subiu para o nível " + nivel + ".");
    }


    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Pontuação: " + pontuacao);
        System.out.println("Nível: " + nivel);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
