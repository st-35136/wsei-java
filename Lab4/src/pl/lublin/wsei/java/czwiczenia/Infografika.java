package pl.lublin.wsei.java.czwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {

    private String fileText;

    public String tytul;
    public String adresStrony;
    public String adresMiniaturki;
    public String adresGrafiki;
    public String szerokosc;
    public String wysokosc;
    public String rozmiar;

    public Infografika(String fileText){
        this.fileText = fileText;

        Pattern patt = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = patt.matcher(fileText);

        if(m.find()){
            this.tytul = m.group(1);
        }
        else{
            System.out.println("Nie znaleziono tytulu");
        }

        patt = Pattern.compile("<link>(.*)</link>");
        m = patt.matcher(fileText);

        if(m.find()){
            this.adresStrony = m.group(1);
        }
        else{
            System.out.println("Nie znaleziono adresu strony");
        }

        patt = Pattern.compile("media:thumbnail url(.*?) ");
        m = patt.matcher(fileText);

        if(m.find()){
            this.adresMiniaturki = m.group(1);
        }
        else{
            System.out.println("Nie znaleziono adresu miniaturki");
        }

        patt = Pattern.compile("media:content url(.*?) ");
        m = patt.matcher(fileText);

        if(m.find()){
            this.adresGrafiki = m.group(1);
        }
        else{
            System.out.println("Nie znaleziono adresu grafiki");
        }

        patt = Pattern.compile("width=\"(.*)\" ");
        m = patt.matcher(fileText);

        if(m.find()){
            this.szerokosc = m.group(1);
            this.rozmiar = szerokosc + "*";
        }
        else{
            System.out.println("Nie znaleziono szerokosci");
        }

        patt = Pattern.compile("height=\"(.*)\"");
        m = patt.matcher(fileText);

        if(m.find()){
            this.wysokosc = m.group(1);
            this.rozmiar+=wysokosc;
        }
        else{
            System.out.println("Nie znaleziono wysokosci");
        }

    }

    public void print(){
        System.out.println("Znaleziono tytul: " + this.tytul);
        System.out.println("Adres strony: " + this.adresStrony);
        System.out.println("Adres miniaturki: " + this.adresMiniaturki);
        System.out.println("Adres grafiki: " + this.adresGrafiki);
        System.out.println("rozmiar: " + this.rozmiar);
    }

}
