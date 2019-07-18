package Master;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public abstract class Controller {
    
    public abstract void create(Object ...obj);
    
    public abstract void update(Object ...obj);
    
    public abstract void delete(int id);
    
    public abstract void delete(String id);
    
    public abstract ArrayList<?> getAllData();
    
    public abstract ArrayList<?> getById(int id);
    
    public abstract ArrayList<?> getById(String id);
    
    public abstract DefaultTableModel viewAll();
}
