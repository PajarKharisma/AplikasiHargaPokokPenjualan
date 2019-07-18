package Model;

import Master.Model;

public class JenisPekerjaan extends Model{
    private int idJp;
    private String namaPekerjaan;
    private int upah;

    public JenisPekerjaan() {
        super("jenis_pekerjaan");
    }

    public JenisPekerjaan(int idJp, String namaPekerjaan, int upah) {
        this.idJp = idJp;
        this.namaPekerjaan = namaPekerjaan;
        this.upah = upah;
    }

    public int getIdJp() {
        return idJp;
    }

    public void setIdJp(int idJp) {
        this.idJp = idJp;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    public int getUpah() {
        return upah;
    }

    public void setUpah(int upah) {
        this.upah = upah;
    }
}
