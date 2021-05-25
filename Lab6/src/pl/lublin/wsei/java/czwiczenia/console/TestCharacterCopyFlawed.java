package pl.lublin.wsei.java.czwiczenia.console;

import java.io.*;
import java.time.Instant;

public class TestCharacterCopyFlawed {

    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;

        long startTime = Instant.now().toEpochMilli();

        try {
            in = new BufferedReader(new FileReader("sample_1920×1280.tiff"));
            out = new BufferedWriter(new FileWriter("img_copy.tiff"));
            int c;

            while((c = in.read()) != -1){
                out.write(c);
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
            if(out != null){
                out.close();
            }
        }

        System.out.println("Czas wykonania w nanosekundach: " + (Instant.now().toEpochMilli() - startTime));
    }

}
