package Sistema;

import Sistema.Models.Conta;
import Sistema.Models.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();

        menuOperacoes();
    }

    public static void menuOperacoes(){
        System.out.println("----------------------------------------------");
        System.out.println("----------Bem Vindo a Nossa Agência-----------");
        System.out.println("----------------------------------------------");
        System.out.println("** Selecione a operação que deseja realizar **");
        System.out.println("|   Opção 1 - Criar Conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");

        int optionMenu = input.nextInt();

        switch (optionMenu){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Obrigado por usar nosso serviço.");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                menuOperacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoaCliente = new Pessoa(nome,cpf,email);

        Conta contaCliente = new Conta(pessoaCliente);

        contasBancarias.add(contaCliente);
        System.out.println("Sua Conta foi criada com sucesso!");

        menuOperacoes();
    }

    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if(contasBancarias.size() > 0){
            // foreich para procurar o numero da conta
            for(Conta c: contasBancarias){
                if(c.getNumeroConta() == numeroConta){
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar(){
        System.out.println("Número da conta: ");
        int numeroDaConta = input.nextInt();

        Conta conta = encontrarConta(numeroDaConta);

        if (conta != null){
            System.out.println("Valor que desejar depositar: ");
            double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);

            System.out.println("Deposito efetuado com sucesso!");
        } else {
            System.out.println( "Deposito não realizado \n" +
                                "Conta não encontrada");
        }

        menuOperacoes();
    }

    public static void sacar(){
        System.out.println("Digite o número da conta: ");
        int numeroDaConta = input.nextInt();

        Conta conta = encontrarConta(numeroDaConta);

        if(conta != null){
            System.out.println("Digite o valor que deseja sacar: ");
            double valorSaque = input.nextDouble();

            conta.sacar(valorSaque);
            System.out.println("Saque Realizado com sucesso!");
        } else{
            System.out.println("Saque não realizado!");
        }
        menuOperacoes();
    }

    public static void transferir(){
        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null){
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null){
                System.out.println("Valor da transferência: ");
                double valor = input.nextInt();

                contaRemetente.transferir(contaDestinatario,valor);
            }
        }
        menuOperacoes();
    }

    public static void listar(){
        if (contasBancarias.size() > 0){
            for( Conta c: contasBancarias){
                System.out.println(c);
            }
        }else{
            System.out.println("Sem conta cadastradas no sistema");
        }
        menuOperacoes();
    }
}