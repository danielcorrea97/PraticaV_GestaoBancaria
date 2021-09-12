package br.com.meuprojeto.gestaobancaria;

import java.util.Scanner;

public class Menu {
    static Scanner ler = new Scanner(System.in);
    public static int menu(){
        int opcao;
        do{
            System.out.println("1 - Criar Conta Corrente");
            System.out.println("2 - Deposito");
            System.out.println("3 - Saque");
            System.out.println("4 - Consultar Saldo");
            System.out.println("5 - Sair");
            System.out.print("Digite a opcao: ");
            opcao = ler.nextInt();
        }while (opcao < 1 || opcao > 5);

        return opcao;
    }
}
