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
                    break;
                case 3:
                    indice = localizarContas(contas, solicitaConta());
                    if (indice != -1){
                        realizarSaque(contas.get(indice));
                    }
                    break;
                case 4:
                    indice = localizarContas(contas, solicitaConta());
                    if (indice != -1){
                        consultarSaldo(contas.get(indice));
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
        }else{
            System.out.println("Conta já existe");
        }
    }

    static void realizarDeposito(Conta conta){
        System.out.println("Digite o valor: ");
        conta.saldo += ler.nextDouble();
    }

    static void realizarSaque(Conta conta){
        System.out.println("Digite o valor: ");
        conta.saldo -= ler.nextDouble();
    }

    static void consultarSaldo(Conta conta){
        System.out.println("Saldo: " + conta.saldo);
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
        System.out.println("Digite o numero da conta: ");
        numConta = ler.nextInt();

        return numConta;
    }
}
