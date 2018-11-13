package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class KontoTest {


    Konto konto = new Konto(new Person("palle","666"),100);


    @Test
    public void getSaldo() {

        assertEquals(100, konto.getSaldo());
    }

    @Test
    public void getPerson() {
    }

    @Test
    public void indsætPosetiv() {
        konto.indsæt(100);
        assertEquals(200, konto.getSaldo());
    }

    @Test
    public void indsætNegtiv() {
        konto.indsæt(-100);
        assertEquals(100, konto.getSaldo());

    }

    @Test
    public void hævPosetiv() {

        konto.hæv(50);
        assertEquals(50, konto.getSaldo());

    }
    @Test
    public void hævNegative() {
        konto.hæv(-50);
        assertEquals(100, konto.getSaldo());
    }
}