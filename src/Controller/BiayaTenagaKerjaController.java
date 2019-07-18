package Controller;

import DataAccessObject.BiayaTenagaKerjaDao;
import DataAccessObject.JenisPekerjaanDao;
import DataAccessObject.ProdukDao;
import Master.Controller;
import Master.Model;
import Model.BiayaTenagaKerja;
import Model.JenisPekerjaan;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class BiayaTenagaKerjaController extends Controller {

    private final BiayaTenagaKerjaDao dao;
    private final ProdukDao daoP;
    private final JenisPekerjaanDao daoJp;

    public BiayaTenagaKerjaController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new BiayaTenagaKerjaDao();
        daoP = new ProdukDao();
        daoJp = new JenisPekerjaanDao();
    }

    @Override
    public void create(Object... obj) {
        int idProduk = (int) obj[0];
        int idJp = (int) obj[1];

        JenisPekerjaan jp = daoJp.getById(idJp).get(0);
        int upah = jp.getUpah();

        int jmlPekerja = (int) obj[2];
        int total = upah * jmlPekerja;

        Model m = new BiayaTenagaKerja();
        BiayaTenagaKerja model = (BiayaTenagaKerja) m;
        
        model.setIdProduk(idProduk);
        model.setIdJp(idJp);
        model.setJumlahPekerja(jmlPekerja);
        model.setTotal(total);
        
        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        int idBiayatk = (int) obj[0];
        int idProduk = (int) obj[1];
        int idJp = (int) obj[2];

        JenisPekerjaan jp = daoJp.getById(idJp).get(0);
        int upah = jp.getUpah();

        int jmlPekerja = (int) obj[3];
        int total = upah * jmlPekerja;

        Model m = new BiayaTenagaKerja();
        BiayaTenagaKerja model = (BiayaTenagaKerja) m;
        
        model.setIdBiayaTk(idBiayatk);
        model.setIdProduk(idProduk);
        model.setIdJp(idJp);
        model.setJumlahPekerja(jmlPekerja);
        model.setTotal(total);
        
        dao.update(model);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel viewAll() {
        return dao.viewAll();
    }

    public DefaultTableModel viewAllByNamaProduk(String nama){
        return dao.viewAllByNamaProduk(nama);
    }
    
    public DefaultTableModel viewDetail(int idProduk){
        return dao.viewDetail(idProduk);
    }
}
