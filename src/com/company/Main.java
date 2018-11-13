package com.company;   // Det her projekt laver vi test på inden vi refaktorisere

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Konto> kontoArrayList = new ArrayList<>();


    public static void main(String[] args) {
        // write your code here


//        Konto konto = new Konto(new Person("nikolaj", "111"), 1000);
//
//        System.out.println(konto.udskrivKonto(konto));


        opret("Nik", "1", 1000);
        opret("bo", "2", 1000);
        opret("noller", "3", 1000);
        opret("hønse", "4", 1000);
        opret("jønke", "5", 1000);


        String menuValg = "du kan vælge mellem følgende funktioner \n" +
                "indsæt\n" +
                "hæv\n" +
                "inf0\n" +
                "udskriv \n" +
                ":";

        String komando = "";
        String svar = "";
        int beløb = 0;

        System.out.println("velkommen til min bank diskression er en dyd");

        while (true) {

            System.out.print(menuValg);

            komando = scanner.nextLine();

            switch (komando) {

                case "indsæt": {
//                    System.out.println("angiv personnummer");
//                    svar = scanner.nextLine();                      // se om du ikke kan flytte det her til findkonto
                    Konto konto = findKonto();
                    if (konto != null) {
                        System.out.println("angiv beløb du ønsker indsat");
                        beløb = Integer.parseInt(scanner.nextLine()); // for at undgå problemer med scanneren
                        System.out.println(konto.indsæt(beløb));

                    } else {
                        System.out.println("kontoen fandtes ikke");
                    }
                    break;
                }


                case "hæv": {
//                    System.out.println("angiv personnummer");
//                    svar = scanner.nextLine();
//                    Konto konto = findKonto(svar);

                    Konto konto = findKonto();

                    if (konto != null) {
                        System.out.println("angiv beløb du ønsker at hæve");
                        beløb = Integer.parseInt(scanner.nextLine()); // for at undgå problemer med scanneren
                        System.out.println(konto.hæv(beløb));
                    }

                    break;
                }
                case "info": {
//                        System.out.println("angiv personnummer");
//                        svar = scanner.nextLine();
                    Konto konto = findKonto();
                    if (konto != null) {

                        System.out.println(konto.udskrivKonto());
                    }

                    break;
                }

                case "udskriv": {

                    udskrivListe();
                    break;
                }

                case "fjern":
                    fjernKonto();
                    break;

                case "overfør":
                    System.out.println(overfør());
                    break;


                default: {
                    System.out.println("ukendt komando ");
                }
            }


            if (komando.equalsIgnoreCase("q")) {
                break;
            }


        }


    }

    // opretkonto

    public static Konto opret(String name, String personNummer, int saldo) {

        Konto konto = new Konto(new Person(name, personNummer), saldo);

        kontoArrayList.add(konto);

        return konto;
    }


    public static String getInput(String s) {

        System.out.println(s);
        return scanner.nextLine();

    }


    public static Konto findKonto() {

        String s = getInput("angiv kontonummer");

        for (Konto k : kontoArrayList
        ) {
            if (k.getPerson().getPersonNumber().equalsIgnoreCase(s)) {

                return k;
            }
        }
        return null;
    }


    // fjern konto fra listen.


    public static void fjernKonto() {

        Konto konto = findKonto();
        kontoArrayList.remove(konto);
    }

    // udskriv kontoer i listen

    public static void udskrivListe() {

        for (Konto k : kontoArrayList
        ) {
            System.out.println(k.udskrivKonto());
        }

    }

    //find total indestående

    // flyt penge mellem to kontoer.


    public static String overfør() {

        System.out.println("følg anvisningen. Start med angive afsender kontoen konto");


        Konto afsender = findKonto();
        System.out.println("angiv modtageren :");
        Konto modtager = findKonto();

        if (afsender != null && modtager != null) {

            int beløb = Integer.parseInt(getInput("angiv beløb"));


            if (beløb < afsender.getSaldo() && beløb > 0) {

                afsender.hæv(beløb);
                modtager.indsæt(beløb);

                return afsender.udskrivKonto() + " \n\n" + modtager.udskrivKonto();

            } else {
                return "der er noget galt med beløbet ";
            }
        }

            return "en af parterne findes ikke";


        }



}