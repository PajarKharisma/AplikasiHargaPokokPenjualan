package Master;

import Config.KoneksiDb;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public abstract class DataAccessObject {
    protected Connection con;
    protected Statement st;
    protected ResultSet rs;
    protected PreparedStatement ps;
    
    public DataAccessObject() throws SQLException, IOException, FileNotFoundException, ParseException{
        con = new KoneksiDb().getConnect();
    }
    
    public abstract void create(Model m);
    
    public abstract void update(Model m);
    
    public abstract void delete(int id);
    
    public abstract void delete(String id);
    
    protected abstract ArrayList<?> getByParam(String query);
    
    public abstract ArrayList<?> getAllData();
    
    public abstract ArrayList<?> getById(int id);
    
    public abstract ArrayList<?> getById(String id);
    
    protected abstract DefaultTableModel viewByParam(String query);
    
    public abstract DefaultTableModel viewAll();
}
