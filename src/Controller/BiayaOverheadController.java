package Controller;

import DataAccessObject.AlatDao;
import DataAccessObject.BiayaOverheadDao;
import Master.Controller;
import Master.Model;
import Model.Alat;
import Model.BiayaOverhead;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class BiayaOverheadController extends Controller {

    private final BiayaOverheadDao dao;
    private final AlatDao daoAlat;

    public BiayaOverheadController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new BiayaOverheadDao();
        daoAlat = new AlatDao();
    }

    @Override
    public void create(Object... obj) {
        int idAlat = (int) obj[0];

        Alat alat = daoAlat.getById(idAlat).get(0);

        String namaAlat = alat.getNamaAlat();
        int jumlah = alat.getJumlah();
        int umurEkonomis = alat.getUmurEkonomis();

        int hargaPerolehan = (int) obj[1];
        int nilaiSisa = hargaPerolehan / umurEkonomis;
        int hasilPertahun = hargaPerolehan - (nilaiSisa / umurEkonomis);
        int hasilPerbulan = hasilPertahun / 12;

        Model m = new BiayaOverhead();
        BiayaOverhead model = (BiayaOverhead) m;
        
        model.setIdAlat(idAlat);
        model.setHargaPerolehan(hargaPerolehan);
        model.setNilaiSisa(nilaiSisa);
        model.setHasilPetahun(hasilPertahun);
        model.setHasilPerbulan(hasilPerbulan);
        
        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        int idBo = (int) obj[0];
        int idAlat = (int) obj[1];

        Alat alat = daoAlat.getById(idAlat).get(0);

        String namaAlat = alat.getNamaAlat();
        int jumlah = alat.getJumlah();
        int umurEkonomis = alat.getUmurEkonomis();

        int hargaPerolehan = (int) obj[2];
        int nilaiSisa = hargaPerolehan / umurEkonomis;
        int hasilPertahun = hargaPerolehan - (nilaiSisa / umurEkonomis);
        int hasilPerbulan = hasilPertahun / 12;

        Model m = new BiayaOverhead();
        BiayaOverhead model = (BiayaOverhead) m;
        
        model.setIdBo(idBo);
        model.setIdAlat(idAlat);
        model.setHargaPerolehan(hargaPerolehan);
        model.setNilaiSisa(nilaiSisa);
        model.setHasilPetahun(hasilPertahun);
        model.setHasilPerbulan(hasilPerbulan);
        
        dao.create(model);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getAllData() {
        return dao.getAllData();
    }

    @Override
    public ArrayList<?> getById(int id) {
        return dao.getById(id);
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel viewAll() {
        return dao.viewAll();
    }

    public DefaultTableModel viewByNamaAlat(String namaAlat){
        return dao.viewByNamaAlat(namaAlat);
    }
}
