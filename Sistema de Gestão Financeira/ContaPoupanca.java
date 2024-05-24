public class ContaPoupanca extends Conta {
    private double taxaRendimento;
    private String dataAniversario;

    public ContaPoupanca(String numero, double taxaRendimento, String dataAniversario) {
        super(numero);
        this.taxaRendimento = taxaRendimento;
        this.dataAniversario = dataAniversario;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
}
