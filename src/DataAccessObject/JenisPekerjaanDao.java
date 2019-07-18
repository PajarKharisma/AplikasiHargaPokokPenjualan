package DataAccessObject;

import Master.DataAccessObject;
import Master.Model;
import Model.JenisPekerjaan;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class JenisPekerjaanDao extends DataAccessObject {

    public JenisPekerjaanDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        JenisPekerjaan model = (JenisPekerjaan) m;
        String namaPekerjaan = model.getNamaPekerjaan();
        int upah = model.getUpah();

        try {
            String sql = "INSERT INTO jenis_pekerjaan(nama_pekerjaan, upah) VALUES(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, namaPekerjaan);
            ps.setInt(2, upah);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        JenisPekerjaan model = (JenisPekerjaan) m;
        int idJp = model.getIdJp();
        String namaPekerjaan = model.getNamaPekerjaan();
        int upah = model.getUpah();
        String sql = "UPDATE jenis_pekerjaan SET nama_pekerjaan='" + namaPekerjaan + "', upah=" + upah + " WHERE id_jp=" + idJp;
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
            String sql = "DELETE from jenis_pekerjaan WHERE id_jp=" + id;
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
    protected ArrayList<JenisPekerjaan> getByParam(String query) {
        ArrayList<JenisPekerjaan> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                JenisPekerjaan model = new JenisPekerjaan();
                model.setIdJp(rs.getInt("id_jp"));
                model.setNamaPekerjaan(rs.getString("nama_pekerjaan"));
                model.setUpah(rs.getInt("upah"));
                list.add(model);
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<JenisPekerjaan> getAllData() {
        String query = "SELECT * FROM jenis_pekerjaan";
        return getByParam(query);
    }

    @Override
    public ArrayList<JenisPekerjaan> getById(int param) {
        String query = "SELECT * FROM jenis_pekerjaan WHERE id_jp=" + param;
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
        mdl.addColumn("Id Pekerjaan");
        mdl.addColumn("Nama Pekerjaan");
        mdl.addColumn("Upah");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_jp"),
                    rs.getString("nama_pekerjaan"),
                    rs.getInt("upah")
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
        String query = "SELECT * FROM jenis_pekerjaan";
        return viewByParam(query);
    }

    public DefaultTableModel viewByNama(String param) {
        String query = "SELECT * FROM jenis_pekerjaan WHERE nama_pekerjaan LIKE %'" + param + "'%";
        return viewByParam(query);
    }
}
