package Model;

import Master.Model;

public class BiayaBahanPenolong extends Model{
    private int idBiayaBp;
    private int idProduk;
    private int idBp;
    private int jumlah;
    private int total;

    public BiayaBahanPenolong() {
        super("biaya_bp");
    }

    public BiayaBahanPenolong(int idBiayaBp, int idProduk, int idBp, int jumlah, int total) {
        this.idBiayaBp = idBiayaBp;
        this.idProduk = idProduk;
        this.idBp = idBp;
        this.jumlah = jumlah;
        this.total = total;
    }

    public int getIdBiayaBp() {
        return idBiayaBp;
    }

    public void setIdBiayaBp(int idBiayaBp) {
        this.idBiayaBp = idBiayaBp;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public int getIdBp() {
        return idBp;
    }

    public void setIdBp(int idBp) {
        this.idBp = idBp;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
