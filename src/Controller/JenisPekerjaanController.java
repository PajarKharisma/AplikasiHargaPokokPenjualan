package Controller;

import DataAccessObject.JenisPekerjaanDao;
import Master.Controller;
import Master.Model;
import Model.JenisPekerjaan;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class JenisPekerjaanController extends Controller {
    
    private final JenisPekerjaanDao dao;
    
    public JenisPekerjaanController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new JenisPekerjaanDao();
    }
    
    @Override
    public void create(Object... obj) {
        Model m = new JenisPekerjaan();
        JenisPekerjaan model = (JenisPekerjaan) m;
        
        model.setNamaPekerjaan((String) obj[0]);
        model.setUpah((int) obj[1]);
        
        dao.create(model);
    }
    
    @Override
    public void update(Object... obj) {
        Model m = new JenisPekerjaan();
        JenisPekerjaan model = (JenisPekerjaan) m;
        
        model.setIdJp((int) obj[0]);
        model.setNamaPekerjaan((String) obj[1]);
        model.setUpah((int) obj[2]);
        
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
    
    public DefaultTableModel viewByNama(String nama) {
        return dao.viewByNama(nama);
    }
}
