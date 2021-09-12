package br.com.meuprojeto.gestaobancaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner ler = new Scanner(System.in);
    static ArrayList<Conta> contas = new ArrayList<>();
    public static void main(String[] args) {
        listarMenu();
    }

    static void listarMenu(){
        int opcao;
        int indice;
        do{
            opcao = Menu.menu();
            switch (opcao){
                case 1:
                    criarConta(contas);
                    break;
                case 2:
                    indice = localizarContas(contas, solicitaConta());
                    if (indice != -1){
                        realizarDeposito(contas.get(indice));
                    }
                    else {
                    	System.out.println("Conta inexistente!");
                    }
                    break;
                case 3:
                    indice = localizarContas(contas, solicitaConta());
                    if (indice != -1){
                        realizarSaque(contas.get(indice));
                    }
                    else {
                    	System.out.println("Conta inexistente!");
                    }
                    break;
                case 4:
                    indice = localizarContas(contas, solicitaConta());
                    if (indice != -1){
                        consultarSaldo(contas.get(indice));
                    }
                    else {
                    	System.out.println("Conta inexistente!");
                    }
                    break;
            }
        }while (opcao != 5);

    }

    static void criarConta(ArrayList<Conta> contas){
        int numConta = solicitaConta();
        if(localizarContas(contas, numConta) == -1){
            Conta conta = new Conta(numConta);
            contas.add(conta);
            System.out.println("Conta criada com sucesso!");
        }else{
            System.out.println("Conta ja existe");
        }
    }

    static void realizarDeposito(Conta conta){
        System.out.print("Digite o valor: ");
        double dep = ler.nextDouble();
        if(dep > 0) {
        	conta.saldo += dep;
        	System.out.println("Seu novo saldo é de: R$" + conta.saldo );
        }
        else {
        	System.out.println("Valor inválido para deposito!");
        }
    }

    static void realizarSaque(Conta conta){
    	System.out.println("Valor disponível para saque: " + "R$" + conta.saldo);
        System.out.print("Digite o valor que deseja sacar: ");
        double saque = ler.nextDouble();
        if(saque <= conta.saldo) {
        	conta.saldo -= saque;
        	System.out.println("Valor sacado! Seu saldo restante é de: R$" + conta.saldo );
        }
        else {
        	System.out.println("Valor indisponível para saque!");
        }
    }

    static void consultarSaldo(Conta conta){
        System.out.println("Saldo: " + "R$" + conta.saldo);
    }

    static int localizarContas(ArrayList<Conta> contas, int numConta){
        int indice = -1;
        for (int i = 0; i < contas.size(); i++) {
            if(contas.get(i).numeroConta == numConta){
                indice = i;
            }
        }
        return indice;
    }

    static int solicitaConta(){
        int numConta;
        System.out.print("Digite o numero da conta: ");
        numConta = ler.nextInt();

        return numConta;
    }
}
