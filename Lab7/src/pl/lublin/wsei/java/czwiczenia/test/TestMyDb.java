package pl.lublin.wsei.java.czwiczenia.test;

import pl.lublin.wsei.java.czwiczenia.MyDB;

import java.sql.Connection;

public class TestMyDb {

    public static void main(String[] args) {
        MyDB db = new MyDB("localhost", 3306, "mydb", "root", "kekichkakich123");

        Connection conn = db.getConnection();
        if(conn!=null)
            System.out.println("Polaczenie z baza danych nawiazane");
        else
            System.out.println("test");


    }

}
