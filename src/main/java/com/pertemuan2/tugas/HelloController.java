package com.pertemuan2.tugas;

import com.pertemuan2.tugas.model.Siswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    public TextField addNrp;
    public TextField addNama;
    public Button add;
    public TextField delNrp;
    public Button del;
    public TableView table;
    public TableColumn column1;
    public TableColumn column2;

    private ObservableList<Siswa> listSiswa;

    public void initialize() {
        listSiswa = FXCollections.observableArrayList();
        table.setItems(listSiswa);
        column1.setCellValueFactory(new PropertyValueFactory<>("nrp"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nama"));
    }

    @FXML
    public void addNewStudent(ActionEvent actionEvent) {
        int nrp = Integer.parseInt(addNrp.getText());
        String nama = addNama.getText();
        listSiswa.add(new Siswa(nrp,nama));
        addNrp.setText("");
        addNama.setText("");
    }

    public void delStudent(ActionEvent actionEvent) {
        int del = Integer.parseInt(delNrp.getText());
        for (int i=0; i < listSiswa.size(); i++){
            if (del == listSiswa.get(i).getNrp()) {
                listSiswa.remove(i);
                delNrp.setText("");
                break;
            }
        }
    }
}