package pl.lublin.wsei.java.czwiczenia.console;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyNoblista {

    private List<Noblista> noblisty;

    public List<Noblista> getNoblisty(){
        List<Noblista> noblisty = new ArrayList<Noblista>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("nobel_prize_by_winner.csv"));

            List<List<String>> result = new ArrayList<>();


            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                result.add(Arrays.asList(values));
            }


            for(int i = 1; i < result.size(); i++){
                Noblista nobl = new Noblista();
                for(int j = 0; j < result.get(i).size(); j++){

                    switch (j){
                        case 1:
                            if(result.get(j) != null)
                            nobl.setImie(result.get(i).get(j));
                        case 2:
                            nobl.setNazwisko(result.get(i).get(j));
                        case 12:
                            nobl.setRok(result.get(i).get(j));
                        case 13:
                            nobl.setKategoria(result.get(i).get(j));
                        case 16:
                            nobl.setUzasadnienie(result.get(i).get(j));
                        case 19:
                            nobl.setKraj(result.get(i).get(j));
                    }
                }

                noblisty.add(nobl);
            }

            for(List<String> arr : result){
                System.out.println(arr);
            }
        }
        catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        this.noblisty = noblisty;
        return this.noblisty;
    }
}
