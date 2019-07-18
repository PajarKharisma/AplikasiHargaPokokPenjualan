package Model;

import Master.Model;

public class Alat extends Model{
    private int idAlat;
    private String namaAlat;
    private int jumlah;
    private int umurEkonomis;

    public Alat() {
        super("alat");
    }

    public Alat(int idAlat, String namaAlat, int jumlah, int umurEkonomis) {
        this.idAlat = idAlat;
        this.namaAlat = namaAlat;
        this.jumlah = jumlah;
        this.umurEkonomis = umurEkonomis;
    }

    public int getIdAlat() {
        return idAlat;
    }

    public void setIdAlat(int idAlat) {
        this.idAlat = idAlat;
    }

    public String getNamaAlat() {
        return namaAlat;
    }

    public void setNamaAlat(String namaAlat) {
        this.namaAlat = namaAlat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getUmurEkonomis() {
        return umurEkonomis;
    }

    public void setUmurEkonomis(int umurEkonomis) {
        this.umurEkonomis = umurEkonomis;
    }
}
