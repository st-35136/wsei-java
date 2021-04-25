package pl.lublin.wsei.java.czwiczenia;

import pl.lublin.wsei.java.czwiczenia.mylib.StringFun;

import java.util.Scanner;

public class shuffleTest {
    public static void run(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Shuffle test");
        do{
            System.out.println("Podaj tekst do sprawdzenia (Uzyj '_' zamiast spacji)");
            String text = scn.next();
            if(text.equals("0")) break;
            System.out.println("Wynik metody shuffle: " + StringFun.shuffle(text));
        } while(true);
    }
}
