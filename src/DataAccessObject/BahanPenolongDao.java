package DataAccessObject;

import Master.DataAccessObject;
import Model.BahanPenolong;
import Master.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class BahanPenolongDao extends DataAccessObject {

    public BahanPenolongDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        BahanPenolong model = (BahanPenolong) m;
        try {
            String sql = "INSERT INTO bahan_penolong(nama_bp, satuan, harga_satuan) VALUES(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, model.getNamaBp());
            ps.setString(2, model.getSatuan());
            ps.setInt(3, model.getHargaSatuan());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        BahanPenolong model = (BahanPenolong) m;
        String sql = "UPDATE bahan_penolong SET nama_bp='" + model.getNamaBp() + "', satuan='" + model.getSatuan() + "', harga_satuan=" + model.getHargaSatuan() + " WHERE id_bp=" + model.getIdBp();
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
            String sql = "DELETE from bahan_penolong WHERE id_bp=" + id;
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
    protected ArrayList<BahanPenolong> getByParam(String query) {
        ArrayList<BahanPenolong> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Model m = new BahanPenolong();
                BahanPenolong model = (BahanPenolong) m;
                model.setIdBp(rs.getInt("id_bp"));
                model.setNamaBp(rs.getString("nama_bp"));
                model.setSatuan(rs.getString("satuan"));
                model.setHargaSatuan(rs.getInt("harga_satuan"));
                list.add(model);
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<BahanPenolong> getAllData() {
        String query = "SELECT * bahan_penolong";
        return getByParam(query);
    }
    
    @Override
    public ArrayList<BahanPenolong> getById(int param) {
        String query = "SELECT * bahan_penolong WHERE id_alat=" + param;
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
        mdl.addColumn("id_bp");
        mdl.addColumn("Nama");
        mdl.addColumn("Satuan");
        mdl.addColumn("Harga Satuan");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_bp"),
                    rs.getString("nama_np"),
                    rs.getString("satuan"),
                    rs.getInt("harga_satuan")
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
        String query = "SELECT * FROM bahan_penolong";
        return viewByParam(query);
    }

    public DefaultTableModel viewByNama(String param) {
        String query = "SELECT * FROM bahan_penolong WHERE nama_bp='" + param + "'";
        return viewByParam(query);
    }

    public DefaultTableModel viewBySatuan(String param) {
        String query = "SELECT * FROM bahan_penolong WHERE satuan='" + param + "'";
        return viewByParam(query);
    }
}
