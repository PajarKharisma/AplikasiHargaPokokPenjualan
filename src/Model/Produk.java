package Model;

import Master.Model;

public class Produk extends Model{
    private int idProduk;
    private String namaProduk;
    private int jmlProduksi;
    private int harga;
    private int total;

    public Produk() {
        super("produk");
    }

    public Produk(int idProduk, String namaProduk, int jmlProduksi, int harga, int total) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.jmlProduksi = jmlProduksi;
        this.harga = harga;
        this.total = total;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getJmlProduksi() {
        return jmlProduksi;
    }

    public void setJmlProduksi(int jmlProduksi) {
        this.jmlProduksi = jmlProduksi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
