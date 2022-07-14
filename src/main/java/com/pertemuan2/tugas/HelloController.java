package com.pertemuan2.tugas;

import com.pertemuan2.tugas.model.Siswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

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
        listSiswa.add(new Siswa(nrp, nama));
        addNrp.setText("");
        addNama.setText("");
    }

    public void delStudent(ActionEvent actionEvent) {
//        alert confirm membuat confirmasi
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Hapus Data?");
        confirm.setHeaderText(null);
        confirm.setContentText("Yakin menghapus data?");
//        kalo ok baru di delete
        if (confirm.showAndWait().get() == ButtonType.OK){
            int del = Integer.parseInt(delNrp.getText());
            for (int i = 0; i < listSiswa.size(); i++) {
                if (del == listSiswa.get(i).getNrp()) {
                    listSiswa.remove(i);
                    delNrp.setText("");
                    break;
        }
//            alert type warning untuk membuat pop up windows pemberitahuan
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Tidak ditemukan");
            alert.setContentText("Nomor NRP yang anda cari tidak ada");
            alert.showAndWait();
            delNrp.setText("");
            }
        }
    }
}