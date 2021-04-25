package pl.lublin.wsei.java.czwiczenia.mylib;

import java.util.Random;

public final class PasswordGenerator {
    private  int dlugosc = 6;
    private  boolean maleLitery = true;
    private  boolean wielkieLitery = true;
    private  boolean cyfry = true;
    private  boolean znakiSpecjalne = false;

    private String wielkieLiteryStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String maleLiteryStr = "abcdefghijklmnopqrstuvwxyz";
    private String cyfryStr = "1234567890";
    private String dozwoloneZnakiSpecjalne = "";

    public PasswordGenerator(){

    }

    public PasswordGenerator(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public PasswordGenerator(int dlugosc, boolean maleLitery) {
        this.dlugosc = dlugosc;
        this.maleLitery = maleLitery;
    }

    public PasswordGenerator(int dlugosc, boolean maleLitery, boolean wielkieLitery) {
        this.dlugosc = dlugosc;
        this.maleLitery = maleLitery;
        this.wielkieLitery = wielkieLitery;
    }

    public PasswordGenerator(int dlugosc, boolean maleLitery, boolean wielkieLitery, boolean cyfry) {
        this.dlugosc = dlugosc;
        this.maleLitery = maleLitery;
        this.wielkieLitery = wielkieLitery;
        this.cyfry = cyfry;
    }

    public PasswordGenerator(int dlugosc, boolean maleLitery, boolean wielkieLitery, boolean cyfry, boolean znakiSpecjalne, String dozwoloneZnakiSpecjalne){
        this.dlugosc = dlugosc;
        this.maleLitery = maleLitery;
        this.wielkieLitery = wielkieLitery;
        this.cyfry = cyfry;
        this.znakiSpecjalne = znakiSpecjalne;
        this.dozwoloneZnakiSpecjalne = dozwoloneZnakiSpecjalne;
    }

    public char[] generatePassword() {
        String combinedChars = "";

        if(maleLitery) combinedChars+=maleLiteryStr;
        if(wielkieLitery) combinedChars+=wielkieLiteryStr;
        if(znakiSpecjalne) combinedChars+=dozwoloneZnakiSpecjalne;
        if(cyfry) combinedChars+=cyfryStr;

        Random random = new Random();
        char[] password = new char[dlugosc];


        for(int i = 0; i< dlugosc; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }
}
