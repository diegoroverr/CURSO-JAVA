public class ContaCorrente extends Conta {
    private double taxaJuros;
    private double limiteChequeEspecial;

    public ContaCorrente(String numero, double taxaJuros, double limiteChequeEspecial) {
        super(numero);
        this.taxaJuros = taxaJuros;
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
}
