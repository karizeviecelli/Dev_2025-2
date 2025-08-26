package com.exemplo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    private Calc calc;

    @BeforeEach
    void setUp() {
        calc = new Calc();
    }

    @Test
    void soma_deveSomarPositivos() {
        int resultado = calc.soma(2, 3);
        assertEquals(5, resultado, "2 + 3 deveria ser 5");
    }

    @Test
    void divide_deveRetornarResultadoCorreto() {
        assertEquals(2, calc.divide(6, 3));
    }

    @Test
    void divide_deveLancarExcecaoQuandoBZero() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> calc.divide(10, 0));
        assertTrue(ex.getMessage().contains("zero"));
    }

    @Test
    void ehPar_deveRetornarTrueParaPares() {
        assertTrue(calc.ehPar(4));
        assertTrue(calc.ehPar(0));
    }

    @Test
    void ehPar_deveRetornarFalseParaImpares() {
        assertFalse(calc.ehPar(3));
    }
}
