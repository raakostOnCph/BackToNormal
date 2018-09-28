package com.company;

public class Konto {


 private Person person;

 private int saldo;

    public Konto(Person person, int saldo) {
        this.person = person;
        this.saldo = saldo;
    }


    public int getSaldo() {
        return  saldo;
    }

    public Person getPerson() {
        return person;
    }

    public String indsæt (int i )   {

        if(i > 0) {

            saldo = saldo + i;
            return  "du har indsat " + i + " kr " + "\n" + " nysaldo er " + getSaldo();
        }
        else {

            return ("beløbet :_" + i + " kunne ikke indsættes, saldo er uændret.\n"  );
        }

    }



    public String hæv(int i ) {

        if(i > 0) {

            saldo = saldo - i;
            return  "du har indsat " + i + " kr " + "\n" + " nysaldo er " + saldo + "\n";
        }
        if (saldo < i) {

            return "beløbet overstiger indestående " + "saldoen er : " + saldo + "\n";
        }
        else {

            return "kan ikke indsætte negativt beløb , saldo er uændret. " + saldo + "\n" ;
        }


    }


  public String udskrivKonto( ) {


        return  "udskriver kontoinformationer \n" +

                person.UdskrivPerson()+
                "-----------------------------\n" +
                "Saldo        : " + saldo + " kr. \n\n";



  }

}
