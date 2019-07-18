package Controller;

import DataAccessObject.AlatDao;
import Master.Controller;
import Master.Model;
import Model.Alat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class AlatController extends Controller {

    private final AlatDao dao;

    public AlatController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new AlatDao();
    }

    @Override
    public void create(Object... obj) {
        Model m = new Alat();
        Alat model = (Alat) m;

        model.setNamaAlat((String) obj[0]);
        model.setJumlah((int) obj[1]);
        model.setUmurEkonomis((int) obj[2]);

        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        Model m = new Alat();
        Alat model = (Alat) m;

        model.setIdAlat((int) obj[0]);
        model.setNamaAlat((String) obj[1]);
        model.setJumlah((int) obj[2]);
        model.setUmurEkonomis((int) obj[3]);

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
        ArrayList<Alat> list = dao.getAllData();
        return list;
    }

    @Override
    public ArrayList<?> getById(int id) {
        ArrayList<Alat> list = dao.getById(id);
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
}
