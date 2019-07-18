package Model;

import Master.Model;

public class BiayaOverhead extends Model{
    private int idBo;
    private int idAlat;
    private int hargaPerolehan;
    private int nilaiSisa;
    private int hasilPetahun;
    private int hasilPerbulan;

    public BiayaOverhead() {
        super("biaya_overhead");
    }

    public BiayaOverhead(int idBo, int idAlat, int hargaPerolehan, int nilaiSisa, int hasilPetahun, int hasilPerbulan) {
        this.idBo = idBo;
        this.idAlat = idAlat;
        this.hargaPerolehan = hargaPerolehan;
        this.nilaiSisa = nilaiSisa;
        this.hasilPetahun = hasilPetahun;
        this.hasilPerbulan = hasilPerbulan;
    }

    public int getIdBo() {
        return idBo;
    }

    public void setIdBo(int idBo) {
        this.idBo = idBo;
    }

    public int getIdAlat() {
        return idAlat;
    }

    public void setIdAlat(int idAlat) {
        this.idAlat = idAlat;
    }

    public int getHargaPerolehan() {
        return hargaPerolehan;
    }

    public void setHargaPerolehan(int hargaPerolehan) {
        this.hargaPerolehan = hargaPerolehan;
    }

    public int getNilaiSisa() {
        return nilaiSisa;
    }

    public void setNilaiSisa(int nilaiSisa) {
        this.nilaiSisa = nilaiSisa;
    }

    public int getHasilPetahun() {
        return hasilPetahun;
    }

    public void setHasilPetahun(int hasilPetahun) {
        this.hasilPetahun = hasilPetahun;
    }

    public int getHasilPerbulan() {
        return hasilPerbulan;
    }

    public void setHasilPerbulan(int hasilPerbulan) {
        this.hasilPerbulan = hasilPerbulan;
    }
}
