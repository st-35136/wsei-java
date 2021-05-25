package pl.lublin.wsei.java.czwiczenia.console;

import java.io.*;
import java.nio.charset.Charset;
import java.time.Instant;

public class TestReadTextEnc {

    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;

        PrintStream out2 = null;

        long startTime = Instant.now().toEpochMilli();

        try {
            in = new BufferedReader(new FileReader("dzieweczki.txt", Charset.forName("windows-1250")));
            out2 = new PrintStream(new FileOutputStream("dzieweczki_java.txt"));
            String line;

            while((line = in.readLine()) != null){
                out2.println(line);
            }
        }
        catch(IOException e){
            System.out.println("IOException: " + e);
            e.printStackTrace();
        }
        finally {
            if(in != null){
                in.close();
            }
            if(out2 != null){
                out2.close();
            }
        }

        System.out.println("Czas wykonania w nanosekundach: " + (Instant.now().toEpochMilli() - startTime));
    }

}
