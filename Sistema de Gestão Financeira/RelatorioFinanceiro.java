public class RelatorioFinanceiro {
    public void gerarRelatorio(Conta conta) {
        System.out.println("Número da Conta: " + conta.numero);
        System.out.println("Saldo Atual: " + conta.consultarSaldo());
        System.out.println("Transações:");
        for (Transacao transacao : conta.getTransacoes()) {
            System.out.println(transacao.getData() + " - " + transacao.getDescricao() + ": " + transacao.getValor() + " (" + transacao.getTipo() + ")");
        }
    }
}
