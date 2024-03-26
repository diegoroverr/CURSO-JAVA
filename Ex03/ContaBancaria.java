import java.util.Scanner;

class ContaBancaria {
    private String nome;
    private int numdaconta;
    private double saldo;

    public ContaBancaria(String nome, int numdaconta, double saldoinicial) {
        this.nome = nome;
        this.numdaconta = numdaconta;
        this.saldo = saldoinicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado com sucesso!");
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void consultarsaldo() {
        System.out.println("Saldo atual: " + saldo);
    }

    public int getnumdaconta() {
        return numdaconta;
    }

    public double getsaldo() {
        return saldo;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public void setnumdaconta(int numdaconta) {
        this.numdaconta = numdaconta;
    }
}
