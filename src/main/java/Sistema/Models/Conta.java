package Sistema.Models;

import Sistema.Utilities.Utils;

public class Conta {

    private static int countContas = 1;
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

    // Criação dos métodos para manipulação da Conta

    public void depositar(double valor){
        if(valor > 0){
            this.saldo = getSaldo() + valor; // setSaldo(getSaldo() + valor) outra forma de manipulação
            System.out.println("Seu deposito foi realizado com sucesso!");
        } else{
            System.out.println("Não foi possível realizar o deposito!");
        }
    }

    public void sacar(double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Seu saque foi realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o saque.");
        }
    }

    public void transferir(Conta contaParaDeposito, double valor){
        if(valor > 0 && this.getSaldo() >= 0){
            this.setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a transferência!");
        }
    }

}
