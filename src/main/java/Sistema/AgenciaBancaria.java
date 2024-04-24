package Sistema;

import Sistema.Models.Conta;

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
                System.out.println("Hello");
                break;
            default:
                break;
        }
    }


}