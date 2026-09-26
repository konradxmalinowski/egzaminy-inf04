package org.example;

import java.util.Scanner;

class Urzadzenie {
    /**
     *
     * nazwa: wyswietl
     * opis: wyświetla kominikat podany jako argument
     * parametry:
     * @param komunikat - tekst, który ma zostać wyświetlony
     * ...
     * zwracany typ i opis: metoda nie zwraca wartości
     * autor: Konrad Malinowski
     */
    public void wyswietl(String komunikat) {
        System.out.println(komunikat);
    }

    public Urzadzenie() {}
}

class Pralka extends Urzadzenie {
    private int program = 0;

    public Pralka() {}

    public int ustawProgram(int program) {
        if (program < 1 || program > 12) {
            this.program = 0;
            return this.program;
        }

        this.program = program;
        return program;
    }
}

class Odkurzacz extends Urzadzenie {
    private boolean stan = false;

    public Odkurzacz() {}

    public void on() {
        if (!stan) {
            this.stan = true;
            wyswietl("Odkurzacz włączono");
        }
    }

    public void off() {
        if (stan) {
            this.stan = false;
            wyswietl("Odkurzacz wyłączono");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Pralka pralka = new Pralka();
        Odkurzacz odkurzacz = new Odkurzacz();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer prania 1..12\n");
        int numer = scanner.nextInt();

        int wartosc = pralka.ustawProgram(numer);
        if (wartosc == 0) {
            System.out.println("Podano niepoprawny numer programu");
        } else {
            System.out.println("Program został ustawiony");
        }

        odkurzacz.on();
        odkurzacz.on();
        odkurzacz.on();
        odkurzacz.wyswietl("Odkurzacz wyladował sie");
        odkurzacz.off();
    }
}
