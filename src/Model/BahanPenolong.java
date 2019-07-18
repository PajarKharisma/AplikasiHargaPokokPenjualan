package Model;

import Master.Model;

public class BahanPenolong extends Model{

    private int idBp;
    private String namaBp;
    private String satuan;
    private int hargaSatuan;

    public BahanPenolong() {
        super("bahan_penolong");
    }

    public BahanPenolong(int idBp, String namaBp, String satuan, int hargaSatuan) {
        this.idBp = idBp;
        this.namaBp = namaBp;
        this.satuan = satuan;
        this.hargaSatuan = hargaSatuan;
    }

    public int getIdBp() {
        return idBp;
    }

    public void setIdBp(int idBp) {
        this.idBp = idBp;
    }

    public String getNamaBp() {
        return namaBp;
    }

    public void setNamaBp(String namaBp) {
        this.namaBp = namaBp;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public int getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }
}
