package com.pertemuan2.tugas.model;

public class Siswa {

    private int nrp;
    private String nama;

    @Override
    public String toString() {
        return getNrp() + "-" + nama;
    }

    public Siswa(int nrp, String nama) {
        this.nrp = nrp;
        this.nama = nama;
    }

    public int getNrp() {
        return nrp;
    }

    public void setNrp(int nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
