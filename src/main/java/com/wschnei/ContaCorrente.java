package com.wschnei;

public class ContaCorrente {

    private enum Categorias {
        SILVER, GOLD, PLATINUM;
    }

    private String nro;
    private String nome;
    private double saldo;
    private Categorias categoria;

    public ContaCorrente(String nro, String nome) {
        this.nro = nro;
        this.nome = nome;
        this.saldo = 0;
        this.categoria = Categorias.SILVER;
    }

    public String getNumeroConta() {
        return nro;
    }

    public String getNomeCorrentista() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCategoria() {
        return categoria.toString();
    }

    public boolean deposito(double valor) {
        if (valor <= 0)
            return false;

        switch (categoria) {
            case SILVER:
                saldo = saldo + valor;
                if (saldo >= 50000)
                    categoria = Categorias.GOLD;
                return true;

            case GOLD:
                saldo = saldo + (valor * 1.01);
                if (saldo >= 200000)
                    categoria = Categorias.PLATINUM;
                return true;

            case PLATINUM:
                saldo = saldo + (valor * 1.025);
                return true;
        }
        return false;
    }

    public boolean retirada(double valor) {
        if (valor <= 0 || valor > saldo)
            return false;

        switch (categoria) {
            case SILVER:
                saldo = saldo - valor;
                return true;

            case GOLD:
                saldo = saldo - valor;
                if (saldo < 250000)
                    categoria = Categorias.SILVER;
                return true;

            case PLATINUM:
                saldo = saldo - valor;
                if (saldo < 100000)
                    categoria = Categorias.GOLD;
                return true;
        }
        return false;
    }
}
