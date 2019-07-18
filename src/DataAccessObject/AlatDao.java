package DataAccessObject;

import Master.DataAccessObject;
import Model.Alat;
import Master.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class AlatDao extends DataAccessObject {

    public AlatDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        Alat model = (Alat) m;
        try {
            String sql = "INSERT INTO alat(nama_alat, jumlah, umur_ekonomis) VALUES(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, model.getNamaAlat());
            ps.setInt(2, model.getJumlah());
            ps.setInt(3, model.getUmurEkonomis());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        Alat model = (Alat) m;
        String sql = "UPDATE alat SET nama_alat='" + model.getNamaAlat()
                + "', jumlah='" + model.getJumlah()
                + "', umur_ekonomis=" + model.getUmurEkonomis()
                + " WHERE id_bp=" + model.getIdAlat();
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE from alat WHERE id_alat=" + id;
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected ArrayList<Alat> getByParam(String query) {
        ArrayList<Alat> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Alat model = new Alat();
                model.setIdAlat(rs.getInt("id_alat"));
                model.setNamaAlat(rs.getString("nama_alat"));
                model.setJumlah(rs.getInt("jumlah"));
                model.setUmurEkonomis(rs.getInt("umur_ekonomis"));
                list.add(model);
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<Alat> getAllData() {
        String query = "select * alat";
        return getByParam(query);
    }

    @Override
    public ArrayList<Alat> getById(int param) {
        String query = "SELECT * alat WHERE id_alat=" + param;
        return getByParam(query);
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected DefaultTableModel viewByParam(String query) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("No");
        mdl.addColumn("Id Alat");
        mdl.addColumn("Nama Alat");
        mdl.addColumn("Jumlah");
        mdl.addColumn("Umur Ekonomis");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_alat"),
                    rs.getString("nama_alat"),
                    rs.getInt("jumlah"),
                    rs.getInt("umur_ekonomis")
                });
                no++;
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return mdl;
    }

    @Override
    public DefaultTableModel viewAll() {
        String query = "SELECT * FROM alat";
        return viewByParam(query);
    }

    public DefaultTableModel viewByNama(String param) {
        String query = "SELECT * FROM alat WHERE nama_alat=" + param + "'";
        return viewByParam(query);
    }
}
