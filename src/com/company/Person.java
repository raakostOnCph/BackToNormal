package com.company;

public class Person {

private String name;


private String personNumber;


    public Person(String name, String PersonNumber) {
        this.name = name;
        this.personNumber = PersonNumber;
    }

    public String getName() {
        return name;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public String UdskrivPerson () {

        return  "navn :       : " + name + "\n" +
                "personnummer : " + personNumber + "\n";

    }
}


