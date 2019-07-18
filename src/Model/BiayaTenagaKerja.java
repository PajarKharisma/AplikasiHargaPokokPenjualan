package Model;

import Master.Model;

public class BiayaTenagaKerja extends Model{
    private int idBiayaTk;
    private int idProduk;
    private int idJp;
    private int jumlahPekerja;
    private int total;

    public BiayaTenagaKerja() {
        super("biaya_tk");
    }

    public BiayaTenagaKerja(int idBiayaTk, int idProduk, int idJp, int jumlahPekerja, int total) {
        this.idBiayaTk = idBiayaTk;
        this.idProduk = idProduk;
        this.idJp = idJp;
        this.jumlahPekerja = jumlahPekerja;
        this.total = total;
    }

    public int getIdBiayaTk() {
        return idBiayaTk;
    }

    public void setIdBiayaTk(int idBiayaTk) {
        this.idBiayaTk = idBiayaTk;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public int getIdJp() {
        return idJp;
    }

    public void setIdJp(int idJp) {
        this.idJp = idJp;
    }

    public int getJumlahPekerja() {
        return jumlahPekerja;
    }

    public void setJumlahPekerja(int jumlahPekerja) {
        this.jumlahPekerja = jumlahPekerja;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
