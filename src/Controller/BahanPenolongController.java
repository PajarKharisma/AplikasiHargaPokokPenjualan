package Controller;

import DataAccessObject.BahanPenolongDao;
import Master.Controller;
import Master.Model;
import Model.BahanPenolong;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class BahanPenolongController extends Controller{

    private final BahanPenolongDao dao;
    
    public BahanPenolongController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new BahanPenolongDao();
    }
    
    @Override
    public void create(Object... obj) {
        Model m = new BahanPenolong();
        BahanPenolong model = (BahanPenolong)m;
        
        model.setNamaBp((String) obj[0]);
        model.setSatuan((String) obj[1]);
        model.setHargaSatuan((int) obj[2]);
        
        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        Model m = new BahanPenolong();
        BahanPenolong model = (BahanPenolong)m;
        
        model.setIdBp((int) obj[0]);
        model.setNamaBp((String) obj[1]);
        model.setSatuan((String) obj[2]);
        model.setHargaSatuan((int) obj[3]);
        
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
        ArrayList<BahanPenolong> list = dao.getAllData();
        return list;
    }

    @Override
    public ArrayList<?> getById(int id) {
        ArrayList<BahanPenolong> list = dao.getById(id);
        return list;
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel viewAll() {
        return dao.viewAll();
    }
    
    public DefaultTableModel viewByNama(String nama) {
        return dao.viewByNama(nama);
    }
    
    public DefaultTableModel viewBySatuan(String satuan) {
        return dao.viewBySatuan(satuan);
    }
}
