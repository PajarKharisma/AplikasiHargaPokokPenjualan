package Controller;

import DataAccessObject.BahanPenolongDao;
import DataAccessObject.BiayaBahanPenolongDao;
import DataAccessObject.ProdukDao;
import Master.Controller;
import Master.Model;
import Model.BahanPenolong;
import Model.BiayaBahanPenolong;
import Model.Produk;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class BiayaBahanPenolongController extends Controller {

    private final BiayaBahanPenolongDao dao;
    private final ProdukDao daoP;
    private final BahanPenolongDao daoBp;

    public BiayaBahanPenolongController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new BiayaBahanPenolongDao();
        daoP = new ProdukDao();
        daoBp = new BahanPenolongDao();
    }

    @Override
    public void create(Object... obj) {
        int idProduk = (int) obj[0];
        int idBp = (int) obj[1];

        BahanPenolong bp = daoBp.getById(idBp).get(0);
        int hargaSatuan = bp.getHargaSatuan();

        int jumlah = (int) obj[2];
        int total = hargaSatuan * jumlah;

        Model m = new BiayaBahanPenolong();
        BiayaBahanPenolong model = (BiayaBahanPenolong) m;
        
        model.setIdProduk(idProduk);
        model.setIdBp(idBp);
        model.setJumlah(jumlah);
        model.setTotal(total);
        
        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        int idBiayaBp = (int) obj[0];
        int idProduk = (int) obj[1];
        int idBp = (int) obj[2];

        BahanPenolong bp = daoBp.getById(idBp).get(0);
        int hargaSatuan = bp.getHargaSatuan();

        int jumlah = (int) obj[3];
        int total = hargaSatuan * jumlah;

        Model m = new BiayaBahanPenolong();
        BiayaBahanPenolong model = (BiayaBahanPenolong) m;
        
        model.setIdBiayaBp(idBiayaBp);
        model.setIdProduk(idProduk);
        model.setIdBp(idBp);
        model.setJumlah(jumlah);
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
        return dao.getById(id);
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel viewAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DefaultTableModel viewAllUmum(){
        return dao.viewAllUmum();
    }
    
    public DefaultTableModel viewByIdUmum(int id){
        return dao.viewByIdUmum(id);
    }
    
    public DefaultTableModel viewDetailAll(int idProduk){
        return dao.viewDetailAll(idProduk);
    }
    
    public int getDetailSum(int idProduk){
        return dao.getDetailSum(idProduk);
    }
}
