package Controller;

import DataAccessObject.UserDao;
import Master.Controller;
import Master.Model;
import Model.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class UserController extends Controller {

    private final UserDao dao;

    public UserController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new UserDao();
    }

    @Override
    public void create(Object... obj) {
        Model m = new User();
        User model = (User) m;
        
        model.setUsername((String) obj[0]);
        model.setPassword((String) obj[1]);
        model.setAkses((int) obj[2]);
        
        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        Model m = new User();
        User model = (User) m;
        
        model.setUsername((String) obj[0]);
        model.setPassword((String) obj[1]);
        model.setAkses((int) obj[2]);
        
        dao.update(model);
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
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

    public DefaultTableModel viewByUsername(String nama) {
        return dao.viewByUsername(nama);
    }
}
