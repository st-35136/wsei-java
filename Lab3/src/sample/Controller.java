package sample;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.DecimalFormat;

public class Controller {


    public Button btnMain;
    public Button btnSubmit;

    public TextField textFieldMain;
    public TextField textFieldPromien;
    public TextField textFieldWysokosc;
    public TextField textFieldGrubosc;
    public Label priceLabel;
    public RadioButton radioBtnStal;
    public RadioButton radioBtnStalNierdz;
    public ToggleGroup toggleGroup;

    private String error;
    private int clickCounter = 0;
    private int gestoscStali = 7800; //m3
    private int gestoscStaliNierdz = 8050; //m3


    public void onBtnAction(ActionEvent actionEvent) {
        ++clickCounter;
        System.out.println("Klikniecie nr " + clickCounter);
        textFieldMain.setText("Klikniecie nr " + clickCounter);
        btnMain.setText("Klikniecie nr " + clickCounter);
        if (clickCounter == 1) {
            btnMain.setText("I jeszcze raz");
            textFieldMain.setText("I jeszcze raz");
        }
    }

    public void onTextFieldAction(){

    }

    public void onBtnSubmitAction(ActionEvent actionEvent) {
        error=null;

        double cena = calcPrice();
        String cenaFormatted = formatDouble(cena);

        double waga = calcWeight();
        String wagaFormatted = formatDouble(waga);

        if(error == null) priceLabel.setText("Cena: " + cenaFormatted + "zl. Waga: " + wagaFormatted + "kg");
        else priceLabel.setText("Error: " + error);
    }

    private double calcPrice() {
        double wysokosc = getWysokosc();
        double promien = getPromien();
        double obszar = getObszar();
        double grubosc = getGrubosc();

        if (grubosc > promien / 2 || grubosc > wysokosc / 2) {
            error = "Nie wlasciwa grubosc";
        }

        if(toggleGroup.getSelectedToggle().equals(radioBtnStal)){
            return obszar*((grubosc)/0.000025);
        }
        if(toggleGroup.getSelectedToggle().equals(radioBtnStalNierdz)){
            return obszar*((grubosc)/0.0000071);
        }

        return 0;
    }

    private double calcWeight(){
        double grubosc = getGrubosc();
        double obszar = getObszar();

        Double obFig = obszar*grubosc;
        if(toggleGroup.getSelectedToggle().equals(radioBtnStal)) {
            return (gestoscStali*obFig);
        }
        if(toggleGroup.getSelectedToggle().equals(radioBtnStalNierdz)) {
            return (gestoscStaliNierdz*obFig);
        }

        return 0;
    }

    private String formatDouble(double d){
        DecimalFormat dFormat = new DecimalFormat("#.##");
        String res = dFormat.format(d);
        return res;
    }

    private double getWysokosc(){
        return Double.parseDouble(textFieldWysokosc.getText());
    }

    private double getPromien(){
        return Double.parseDouble(textFieldPromien.getText());
    }

    private double getGrubosc(){
        Double grubosc = Double.parseDouble(textFieldGrubosc.getText());
        return grubosc/100; // from cm to m;
    }

    private double getObszar(){
        Double wysokosc = getWysokosc();
        Double promien = getPromien();
        return (2 * Math.PI * promien *(wysokosc + promien));
    }

}
