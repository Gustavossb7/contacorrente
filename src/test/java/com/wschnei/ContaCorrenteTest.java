package com.wschnei;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ContaCorrenteTest {
    private ContaCorrente contaCorrente;

    @BeforeEach
    public void init() {
        this.contaCorrente = new ContaCorrente("1", "nome");
    }

    @Test
    public void silverParaGold() {
        Assertions.assertEquals("SILVER", contaCorrente.getCategoria());
        contaCorrente.deposito(50000);
        Assertions.assertEquals("GOLD", contaCorrente.getCategoria());
    }

    @Test
    public void goldParaPlatinum() {
        contaCorrente.deposito(50000);
        contaCorrente.deposito(150000);
        Assertions.assertEquals("PLATINUM", contaCorrente.getCategoria());
    }

    @Test
    public void platinumParaGold() {
        contaCorrente.deposito(50000);
        contaCorrente.deposito(150000);
        contaCorrente.retirada(150000);
        Assertions.assertEquals("GOLD", contaCorrente.getCategoria());
    }

    @Test
    public void goldParaSilver() {
        contaCorrente.deposito(50000);
        contaCorrente.deposito(150000);
        contaCorrente.retirada(150000);
        contaCorrente.retirada(25000);
        Assertions.assertEquals("SILVER", contaCorrente.getCategoria());
    }

    @Test
    public void subirDuasCategorias() {
        contaCorrente.deposito(200000);
        Assertions.assertEquals("GOLD", contaCorrente.getCategoria());
    }

    @Test
    public void descerDuasCategorias() {
        contaCorrente.deposito(50000);
        contaCorrente.deposito(150000);
        contaCorrente.retirada(200000);
        Assertions.assertEquals("GOLD", contaCorrente.getCategoria());
    }

    @Test
    public void depositoNegativo() {
        Assertions.assertEquals(false, contaCorrente.deposito(-1));
    }

    @ParameterizedTest
    @CsvSource({
            "false, 10",
            "false, -1",
            "false, 0"
    })
    public void retiradaComValoresInvalidos(Boolean esperado, double valor) {
        Assertions.assertEquals(esperado, contaCorrente.retirada(valor));
    }

    @Test
    public void silverContinuaSilver() {
        contaCorrente.deposito(5000);
        Assertions.assertEquals("SILVER", contaCorrente.getCategoria());
    }

    @Test
    public void goldContinuaGold() {
        contaCorrente.deposito(50000);
        contaCorrente.deposito(1000);
        Assertions.assertEquals("GOLD", contaCorrente.getCategoria());
    }

    @Test
    public void platinumContinuaPlatinum() {
        contaCorrente.deposito(50000);
        contaCorrente.deposito(150000);
        contaCorrente.deposito(1000);
        Assertions.assertEquals("PLATINUM", contaCorrente.getCategoria());
    }

    @Test
    public void verificaBonusGold() {
        contaCorrente.deposito(50000);
        contaCorrente.deposito(1000);
        Assertions.assertEquals(51010.0, contaCorrente.getSaldo());
    }

    @Test
    public void verificaBonusPlatinum() {
        contaCorrente.deposito(50000);
        contaCorrente.deposito(150000);
        contaCorrente.deposito(1000);
        Assertions.assertEquals(202525.0, contaCorrente.getSaldo());
    }
}
