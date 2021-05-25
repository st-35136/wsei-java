package pl.lublin.wsei.java.czwiczenia;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import pl.lublin.wsei.java.czwiczenia.console.CopyNoblista;
import pl.lublin.wsei.java.czwiczenia.console.Noblista;

import javax.swing.text.TabableView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    public FileChooser fileChooser = new FileChooser();
    public Label labelFileName;
    public TableView MainTableView = new TableView();

    public TableColumn<Noblista, String> nameTableColumn;
    public TableColumn<Noblista, String>  surnameTableColumn;
    public TableColumn<Noblista, String>  yearTableColumn;
    public TableColumn<Noblista, String>  categoryTableColumn;
    public TableColumn<Noblista, String>  motivationTableColumn;
    public TableColumn<Noblista, String>  countryTableColumn;

    CopyNoblista copyNoblista;

    public void onBtnMainAction() throws IOException {
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            labelFileName.setText(file.getAbsolutePath());
            copyNoblista = new CopyNoblista();

            List<Noblista> noblisty = copyNoblista.getNoblisty();

            nameTableColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getImie()));
            surnameTableColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNazwisko()));
            yearTableColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRok()));
            categoryTableColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getKategoria()));
            motivationTableColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getUzasadnienie()));
            countryTableColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getKraj()));

            ObservableList oNoblisty = FXCollections.observableArrayList(noblisty);

            MainTableView.setItems(oNoblisty);
            //C:\wsei-java\Lab6

        } else {
            labelFileName.setText("Please choose file...");
        }
    }

}
