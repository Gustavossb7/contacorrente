package com.wschnei;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        ContaCorrente contaCorrente = new ContaCorrente("1", "waldyr");

        // System.out.println(contaCorrente.getCategoria());
        // System.out.println(contaCorrente.getSaldo());
        // contaCorrente.deposito(50000);
        // System.out.println(contaCorrente.getCategoria());
        // System.out.println(contaCorrente.getSaldo());
        // contaCorrente.deposito(150000);
        // System.out.println(contaCorrente.getCategoria());
        // System.out.println(contaCorrente.getSaldo());
        // contaCorrente.retirada(200000);
        // System.out.println(contaCorrente.getCategoria());
        contaCorrente.deposito(50000);
        contaCorrente.deposito(150000);
        contaCorrente.deposito(1000);

        System.out.println(contaCorrente.getSaldo());
    }
}
