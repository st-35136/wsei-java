package pl.lublin.wsei.java.czwiczenia;

import pl.lublin.wsei.java.czwiczenia.mylib.StringFun;

import java.util.Scanner;

public class anarchizeTest {

    public static void run(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Anarchize test");
        do{
            System.out.println("Podaj tekst do sprawdzenia (Uzyj '_' zamiast spacji)");
            String text = scn.nextLine();
            if(text.equals("0")) break;
            System.out.println("Wynik metody anarchize: " + StringFun.anarchize(text));
        } while(true);
    }
}
