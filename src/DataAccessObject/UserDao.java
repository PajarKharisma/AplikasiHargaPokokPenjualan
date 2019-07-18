package DataAccessObject;

import Master.DataAccessObject;
import Master.Model;
import Model.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class UserDao extends DataAccessObject {

    public UserDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        User user = (User) m;
        try {
            String sql = "insert into user(username, password, akses) values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getAkses());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        User user = (User) m;
        String sql = "UPDATE user SET username='" + user.getUsername() + "', password='" + user.getPassword() + "', akses='" + user.getAkses() + "' WHERE username='" + user.getUsername() + "'";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    public void delete(String username) {
        try {
            String sql = "DELETE from user WHERE username='" + username + "'";
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected ArrayList<User> getByParam(String query) {
        ArrayList<User> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setAkses(rs.getInt("akses"));
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<User> getAllData() {
        String query = "SELECT * from user";
        return getByParam(query);
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
    protected DefaultTableModel viewByParam(String query) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Username");
        mdl.addColumn("Akses");
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    rs.getString("username"),
                    rs.getString("akses")
                });
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
//        Vector data = mdl.getDataVector();
//        for(Object i:data){
//            Vector v = (Vector)i;
//            System.out.println(v.elementAt(0));
//        }
        return mdl;
    }

    @Override
    public DefaultTableModel viewAll() {
        String query = "SELECT * FROM user";
        return viewByParam(query);
    }

    public DefaultTableModel viewByUsername(String username) {
        String query = "select * from user where username='" + username + "'";
        return viewByParam(query);
    }
}
