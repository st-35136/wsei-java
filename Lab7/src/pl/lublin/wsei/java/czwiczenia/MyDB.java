package pl.lublin.wsei.java.czwiczenia;

import javax.swing.*;
import java.sql.*;
import java.util.Properties;

public class MyDB {

    private String user;
    private String password;
    private String host;
    private Number port;
    private String dbName;
    private Connection conn = null;
    private Statement statement;


    public MyDB(String host, Number port, String dbName, String user, String password) {
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
    }

    private void connect(){
        Properties connectionProps = new Properties();

        connectionProps.put("user", user);
        connectionProps.put("password", password);
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        try{
            conn = DriverManager.getConnection(jdbcString, connectionProps);
            statement = conn.createStatement();
        }
        catch(Exception e){
            System.out.println("Blad polaczenia do bazy: " + e.getMessage());
        }

        System.out.println("Connected to database " + dbName);
    }

    public Connection getConnection(){
        if(conn == null)
            connect();
        return conn;
    }

    public void closeConnection(){
        if(conn!=null){
            try{
                conn.close();
            }
            catch(SQLException e){
                System.out.println("Blad przy zamykaniu polaczenia bazadanowego: " + e.getMessage());
            }
        }
    }

    public ResultSet selectData(String selectStatement){
        ResultSet res = null;
        if((conn!=null) && (selectStatement!=null)){
            try{
                res = statement.executeQuery(selectStatement);
            }
            catch(SQLException e){
                System.out.println("Blad realizacji zapytania: " + e.getMessage());
            }
        }

        return res;
    }

}
