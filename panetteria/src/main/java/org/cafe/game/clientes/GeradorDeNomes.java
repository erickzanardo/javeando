package org.cafe.game.clientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorDeNomes {

    static List<String> names = new ArrayList<>();
    static List<String> surnames = new ArrayList<>();
    static Random r = new Random();

    static {
        names.add("Jack");
        names.add("John");
        names.add("James");
        names.add("Martin");
        names.add("Bruce");
        names.add("Robert");
        names.add("Tony");
        names.add("Mike");
        names.add("Clint");
        names.add("Jhonny");
        names.add("Paul");
        names.add("Peter");
        names.add("Ethan");
        names.add("Richard");
        names.add("Vito");
        names.add("Vince");
        names.add("Frank");

        surnames.add("Black");
        surnames.add("Carter");
        surnames.add("Bond");
        surnames.add("McFly");
        surnames.add("Wayne");
        surnames.add("Montana");
        surnames.add("Stark");
        surnames.add("Jackson");
        surnames.add("Eastwood");
        surnames.add("Deep");
        surnames.add("Willians");
        surnames.add("White");
        surnames.add("Mccoy");
        surnames.add("Hatfield");
        surnames.add("Corleone");
        surnames.add("Vercetti");
        surnames.add("Jones");
    }

    public static String gerarNome() {
        String name = names.get(r.nextInt(names.size()));
        String surname = surnames.get(r.nextInt(surnames.size()));

        return name + " " + surname;
    }
}
