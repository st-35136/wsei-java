package pl.lublin.wsei.java.czwiczenia;

import pl.lublin.wsei.java.czwiczenia.mylib.StringFun;

import java.util.Scanner;

public class camelizeTest {
    public static void run(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Camelize test");
        do{
            System.out.println("Podaj tekst do sprawdzenia (Uzyj '_' zamiast spacji)");
            String text = scn.next();
            System.out.println("Podaj regex: ");
            String regex = scn.next();
            if(text.equals("0")) break;
            System.out.println("Wynik metody camelize: " + StringFun.camelize(text,regex));
        } while(true);
    }
}
