package com.pertemuan2.tugas.model;

public class Siswa {

    private int nrp;
    private String nama;
    private int ipa;
    private int ips;

    @Override
    public String toString() {
        return getNrp() + "-" + nama;
    }

    public Siswa(int nrp, String nama, int ipa, int ips) {
        this.nrp = nrp;
        this.nama = nama;
        this.ipa = ipa;
        this.ips = ips;
    }

    public int getIpa() {
        return ipa;
    }

    public void setIpa(int ipa) {
        this.ipa = ipa;
    }

    public int getIps() {
        return ips;
    }

    public void setIps(int ips) {
        this.ips = ips;
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
