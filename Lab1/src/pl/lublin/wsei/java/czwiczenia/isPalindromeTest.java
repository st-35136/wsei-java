package pl.lublin.wsei.java.czwiczenia;

import pl.lublin.wsei.java.czwiczenia.mylib.StringFun;

import java.util.Scanner;

public class isPalindromeTest {
    public static void run(){
        Scanner scn = new Scanner(System.in).useDelimiter(" ");
        do{
            System.out.println("Podaj tekst do sprawdzenia (Uzyj '_' zamiast spacji)");
            String tekst = scn.next();
            if(tekst.equals("0")) break;
            System.out.println("Tekst:" + tekst + " " + (StringFun.isPalindrome(tekst) ? "" : "nie ") + "jest palindromem ");
        }   while(true);
    }
}
