package pl.lublin.wsei.java.czwiczenia;

import pl.lublin.wsei.java.czwiczenia.mylib.Account;
import pl.lublin.wsei.java.czwiczenia.mylib.PasswordGenerator;
import pl.lublin.wsei.java.czwiczenia.mylib.StringFun;


public class Main {

    // komentarz jednolinijkowy

     /*
       komentarz wielolinijkowy
     */

    /**
     *  komentarz javadoc
     *
     * Returns an Image object that can then be painted on the screen.
     * The url argument must specify an absolute <a href="#{@link}">{@link }</a>. The name
     * argument is a specifier that is relative to the url argument.
     * <p>
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     *
     *
     *
     *
     */

    public static String toBinary(Integer num) {
        return Integer.toBinaryString(num);
    }

    public static String toHex(Integer num){
        return Integer.toHexString(num);
    }

    public static String leftPad(String aText, char aChar, int aWidth){
        String res = aText;
        for(int i = 0; i < aWidth - aText.length(); i++){
            res = aChar+res;
        }

        return res;
    }

    public static void main (String[] args){
        System.out.print("Ala\n");
        System.out.print("Ma\n");
        System.out.print("Kota\n");

        int a = 3;

        float b = 4.52f;

        String c = "text";


        System.out.printf("a = %d, b =  %.2f, s = %20s %n", a,b,c);

        System.out.print("Nazywaliśmy to \"Witaminą B3\" \n");

        System.out.printf("alfa\tsin(alfa)\n");

        for(int i = 0; i < 370; i+=10){
            System.out.printf("%d\t%f\t\n", i, Math.sin(i/360.02*Math.PI));
        }

        System.out.printf("%-10s %-10s %-10s\n", "arg", "log2(arg)", "sum(arg)");
        for(int i = 1; i < 10; i++){
            System.out.printf("%-10s %-10s %-10s\n",i, (int)(Math.log(i) / Math.log(2)), i + (int)(Math.log(i) / Math.log(2)));
        }

//        Scanner input = new Scanner(System.in);
//
//        Integer num1 = 0, num2 = 0;
//
//        do{
//            System.out.print("Podaj liczbę które mam dodać ");
//            num1 = input.nextInt();
//            num2 = input.nextInt();
//            if(num1 == 0 || num2 == 0) break;
//            System.out.printf("Wynik dodawania: %d + %d = %d%n", num1, num2, num1+num2);
//        } while(true);

        int num = 12;

        System.out.println(leftPad(toBinary(num), '0', 10).toUpperCase());
        System.out.println(leftPad(toHex(num), '0', 10).toUpperCase());


        Account acc = new Account();
        acc.setName("piotr Golabek");
        System.out.println(acc.getName());
        System.out.printf("%s%n",Account.capitalize("stanisŁaw maruSARz"));
        System.out.println(Account.translit("Привет мир"));

        System.out.println(StringFun.anarchize("heLLo world"));
        System.out.println(StringFun.anarchize("HELLO WORLD"));

        System.out.println(StringFun.camelize("hello java world", " "));
        System.out.println(StringFun.camelize("HELLO_JAVA_WORLD", "_"));

        System.out.println(StringFun.decamelize("helloJavaWorld"));

        System.out.println(StringFun.isPalindrome("Madam, I’m Adam"));

        System.out.println(StringFun.shuffle("hello world"));

        PasswordGenerator p = new PasswordGenerator(
                20,
                true,
                true,
                true,
                true,
                "%!{}"
        );

        System.out.println(p.generatePassword());

        PasswordGenerator p2 = new PasswordGenerator(10, false);
        System.out.println(p2.generatePassword());
    }
}
