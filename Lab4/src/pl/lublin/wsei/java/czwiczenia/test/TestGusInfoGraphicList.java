package pl.lublin.wsei.java.czwiczenia.test;

import pl.lublin.wsei.java.czwiczenia.GusInfoGraphicList;
import pl.lublin.wsei.java.czwiczenia.Infografika;

public class TestGusInfoGraphicList {

    public static void main(String[] args){
        GusInfoGraphicList list = new GusInfoGraphicList("gusInfoGraphic.xml");
        for(Infografika ig: list.infografiki) ig.print();
    }

}
