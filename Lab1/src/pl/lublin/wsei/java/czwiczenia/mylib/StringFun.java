package pl.lublin.wsei.java.czwiczenia.mylib;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StringFun {


    public static String anarchize(String word){
        String res = "";
        char[] chars = word.toCharArray();


        if(Character.isUpperCase(chars[0])) {
            res+=Character.toLowerCase(chars[0]);
            for(int i = 1; i < chars.length; i++){
                if(i%2!=0) chars[i] = Character.toUpperCase(chars[i]);
                else chars[i] = Character.toLowerCase(chars[i]);
                res+=chars[i];
            }
        };
        if(Character.isLowerCase(chars[0])){
            res+= Character.toUpperCase(chars[0]);
            for(int i = 1; i < chars.length; i++){
                if(i%2==0) chars[i] = Character.toUpperCase(chars[i]);
                else chars[i] = Character.toLowerCase(chars[i]);
                res+=chars[i];
            }
        };

        return res;
    }

    public static String camelize(String str, String regex) {

        str = str.toLowerCase();
        String[] subStrings = str.split(regex);
        StringBuilder camelized = new StringBuilder(str.length());
        for (int i = 0; i < subStrings.length; i ++) {
            if(i == 0) camelized.append(subStrings[i]);
            else camelized.append(StringUtils.capitalize(subStrings[i]));
        }
        return camelized.toString();
    }

    public static String decamelize(String str){
        char[] chars = str.toCharArray();
        String res = "";
        for(int i = 0; i < chars.length; i++){
            res+= Character.toLowerCase(chars[i]);
            if(i+1 < chars.length && Character.isUpperCase(chars[i+1])){
                res+=" ";
            }
        }
        return res;
    }

    public static boolean isPalindrome(String str){
        str = str.replaceAll("[^a-zA-Z]","").toLowerCase();
        StringBuilder sb = new StringBuilder(str);
        String palindrome = sb.reverse().toString();

        return palindrome.equals(str);
    }

    public static String shuffle(String str){
        List<Character> characters = new LinkedList<>();
        for(char c:str.toCharArray()){
            characters.add(c);
        }
        StringBuilder result = new StringBuilder();
        for (int index=0;index<str.length();index++){
            int randomPosition = new Random().nextInt(characters.size());
            result.append(characters.get(randomPosition));
            characters.remove(randomPosition);
        }
        return result.toString();
    }
}
