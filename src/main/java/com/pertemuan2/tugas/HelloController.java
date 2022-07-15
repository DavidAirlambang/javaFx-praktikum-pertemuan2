package com.pertemuan2.tugas;

import com.pertemuan2.tugas.model.Siswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

public class HelloController {
    public TextField addNrp;
    public TextField addNama;
    public Button add;
    public TextField delNrp;
    public Button del;
    public TableView<Siswa> table;
    public TableColumn column1;
    public TableColumn column2;
    public TableColumn column3;
    public TableColumn column4;
    public TextField addIpa;
    public TextField addIps;
    public Button update;
    private ObservableList<Siswa> listSiswa;

    public void initialize() {
        listSiswa = FXCollections.observableArrayList();
        table.setItems(listSiswa);
        column1.setCellValueFactory(new PropertyValueFactory<>("nrp"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nama"));
        column3.setCellValueFactory(new PropertyValueFactory<>("ipa"));
        column4.setCellValueFactory(new PropertyValueFactory<>("ips"));

        del.setDisable(true);
        update.setDisable(true);
    }

    @FXML
    public void addNewStudent(ActionEvent actionEvent) {
        int nrp = Integer.parseInt(addNrp.getText());
        String nama = addNama.getText();
        int ipa = Integer.parseInt(addIpa.getText());
        int ips = Integer.parseInt(addIps.getText());
        listSiswa.add(new Siswa(nrp, nama,ipa,ips));
        addNrp.setText("");
        addNama.setText("");
        addIpa.setText("");
        addIps.setText("");
    }

    public void delStudent(ActionEvent actionEvent) {
//        alert confirm membuat confirmasi
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Hapus Data?");
        confirm.setHeaderText(null);
        confirm.setContentText("Yakin menghapus data?");
//        kalo ok baru di delete
        if (confirm.showAndWait().get() == ButtonType.OK){
            int dele = Integer.parseInt(delNrp.getText());
            for (int i = 0; i < listSiswa.size(); i++) {
                if (dele == listSiswa.get(i).getNrp()) {
                    listSiswa.remove(i);
                    delNrp.setText("");
                    addNrp.setText("");
                    addNama.setText("");
                    addIpa.setText("");
                    addIps.setText("");
                    delNrp.setDisable(false);
                    del.setDisable(true);
                    update.setDisable(true);
                    add.setDisable(false);
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

    public void selected(MouseEvent mouseEvent) {
        addNrp.setText(String.valueOf(table.getSelectionModel().getSelectedItem().getNrp()));
        delNrp.setText(String.valueOf(table.getSelectionModel().getSelectedItem().getNrp()));
        delNrp.setDisable(true);
        del.setDisable(false);
        update.setDisable(false);
        add.setDisable(true);
        addNama.setText(table.getSelectionModel().getSelectedItem().getNama());
        addIpa.setText(String.valueOf(table.getSelectionModel().getSelectedItem().getIpa()));
        addIps.setText(String.valueOf(table.getSelectionModel().getSelectedItem().getIps()));
    }

    public void upStudent(ActionEvent actionEvent) {
        table.getSelectionModel().getSelectedItem().setNrp(Integer.parseInt(addNrp.getText()));
        table.getSelectionModel().getSelectedItem().setNama(addNama.getText());
        table.getSelectionModel().getSelectedItem().setIpa(Integer.parseInt(addIpa.getText()));
        table.getSelectionModel().getSelectedItem().setIps(Integer.parseInt(addIps.getText()));
        table.refresh();
        delNrp.setText("");
        addNrp.setText("");
        addNama.setText("");
        addIpa.setText("");
        addIps.setText("");
        del.setDisable(true);
        update.setDisable(true);
        add.setDisable(false);
    }
}