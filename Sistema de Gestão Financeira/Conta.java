import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements OperacoesConta {
    protected String numero;
    protected double saldo;
    protected List<Transacao> transacoes;

    public Conta(String numero) {
        this.numero = numero;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.transacoes.add(new Transacao("Depósito", valor, "receita"));
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            this.transacoes.add(new Transacao("Saque", valor, "despesa"));
        }
    }

    @Override
    public double consultarSaldo() {
        return this.saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void editarTransacao(int indice, String descricao, double valor, String tipo) {
        if (indice >= 0 && indice < transacoes.size()) {
            Transacao transacao = transacoes.get(indice);
            transacao.setDescricao(descricao);
            transacao.setValor(valor);
            transacao.setTipo(tipo);
        }
    }

    public void excluirTransacao(int indice) {
        if (indice >= 0 && indice < transacoes.size()) {
            transacoes.remove(indice);
        }
    }
}
