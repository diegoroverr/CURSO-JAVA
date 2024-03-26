public class Pedido {
    private String tipoPizza;
    private String tamanho;
    private double valor;
    private String enderecoEntrega;

    public Pedido(String tipoPizza, String tamanho, double valor, String enderecoEntrega) {
        this.tipoPizza = tipoPizza;
        this.tamanho = tamanho;
        this.valor = valor;
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getTipoPizza() {
        return tipoPizza;
    }

    public void setTipoPizza(String tipoPizza) {
        this.tipoPizza = tipoPizza;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
}
