package Sistema.Models;

import Sistema.Utilities.Utils;

public class Conta {

    private static int countContas = 0;
    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0;

    public Conta(Pessoa pessoa) {
        this.pessoa = pessoa;
        countContas += 1;
    }

    public static int getCountContas() {
        return countContas;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        return  "\nNúmero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCPF() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(getSaldo()) +
                "\n";
    }

    public void depositar(double valor){

    }

}
