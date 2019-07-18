package DataAccessObject;

import Master.DataAccessObject;
import Master.Model;
import Model.BiayaOverhead;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class BiayaOverheadDao extends DataAccessObject {

    public BiayaOverheadDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        BiayaOverhead model = (BiayaOverhead) m;
        try {
            String sql = "insert into biaya_overhead(id_alat, harga_perolehan, nilai_sisa, hasil_pertahun, hasil_perbulan) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, model.getIdAlat());
            ps.setInt(2, model.getHargaPerolehan());
            ps.setInt(3, model.getNilaiSisa());
            ps.setInt(4, model.getHasilPetahun());
            ps.setInt(4, model.getHasilPerbulan());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        BiayaOverhead model = (BiayaOverhead) m;
        String sql = "UPDATE biaya_overhead SET id_alat=" + model.getIdAlat()
                + ", harga_perolehan=" + model.getHargaPerolehan()
                + ", nilai_sisa=" + model.getNilaiSisa()
                + ", hasil_pertahun=" + model.getHasilPetahun()
                + ", hasil_perbulan=" + model.getHasilPerbulan()
                + " WHERE id_bo=" + model.getIdBo();
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
            String sql = "DELETE from biaya_overhead WHERE id_bp=" + id;
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
    protected ArrayList<BiayaOverhead> getByParam(String query) {
        ArrayList<BiayaOverhead> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                BiayaOverhead model = new BiayaOverhead();
                model.setIdBo(rs.getInt("id_biaya_bp"));
                model.setIdAlat(rs.getInt("id_produk"));
                model.setHargaPerolehan(rs.getInt("id_bp"));
                model.setNilaiSisa(rs.getInt("jumlah"));
                model.setHasilPetahun(rs.getInt("hasil_pertahun"));
                model.setHasilPerbulan(rs.getInt("hasil_perbulan"));
                list.add(model);
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<BiayaOverhead> getAllData() {
        String query = "SELECT * FROM biaya_overhead";
        return getByParam(query);
    }

    @Override
    public ArrayList<BiayaOverhead> getById(int param) {
        String query = "SELECT * FROM biaya_overhead WHERE id_bo=" + param;
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
        mdl.addColumn("Id BO");
        mdl.addColumn("Id Alat");
        mdl.addColumn("Nama Alat");
        mdl.addColumn("Jumlah");
        mdl.addColumn("Umur Ekonomis");
        mdl.addColumn("Harga Perolehan");
        mdl.addColumn("Nilai Sisa");
        mdl.addColumn("Hasil Pertahun");
        mdl.addColumn("Hasil Perbulan");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_bo"),
                    rs.getInt("id_alat"),
                    rs.getString("nama_alat"),
                    rs.getInt("jumlah"),
                    rs.getInt("umur_ekonomis"),
                    rs.getInt("harga_perolehan"),
                    rs.getInt("nilai_sisa"),
                    rs.getInt("hasil_pertahun"),
                    rs.getFloat("hasil_perbulan")
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
        String query = "SELECT"
                        + "bo.id_bo,"
                        + "a.id_alat,"
                        + "a.nama_alat,"
                        + "a.jumlah,"
                        + "a.umur_ekonomis,"
                        + "bo.harga_perolehan,"
                        + "bo.nilai_sisa,"
                        + "bo.hasil_pertahun,"
                        + "bo.hasil_perbulan"
                        + "FROM"
                        + "biaya_overhead bo"
                        + "INNER JOIN alat a ON bo.id_alat = a.id_alat";
        return viewByParam(query);
    }

    public DefaultTableModel viewByNamaAlat(String namaAlat) {
        String query = "SELECT"
                        + "bo.id_bo,"
                        + "a.id_alat,"
                        + "a.nama_alat,"
                        + "a.jumlah,"
                        + "a.umur_ekonomis,"
                        + "bo.harga_perolehan,"
                        + "bo.nilai_sisa,"
                        + "bo.hasil_pertahun,"
                        + "bo.hasil_perbulan"
                        + "FROM"
                        + "biaya_overhead bo"
                        + "INNER JOIN alat a ON bo.id_alat = a.id_alat"
                        + "WHERE a.nama_alat LIKE '%"+ namaAlat +"%'";
        return viewByParam(query);
    }
}
