package pl.lublin.wsei.java.czwiczenia;

import pl.lublin.wsei.java.czwiczenia.mylib.StringFun;

import java.util.Scanner;

public class decamelizeTest{
    public static void run(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Decamelize test");
        do{
            System.out.println("Podaj tekst do sprawdzenia ");
            String text = scn.next();
            if(text.equals("0")) break;
            System.out.println("Wynik metody decamelize: " + StringFun.decamelize(text));
        } while(true);
    }
}
