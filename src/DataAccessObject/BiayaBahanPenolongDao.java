package DataAccessObject;

import Master.DataAccessObject;
import Master.Model;
import Model.BiayaBahanPenolong;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class BiayaBahanPenolongDao extends DataAccessObject {

    public BiayaBahanPenolongDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        BiayaBahanPenolong model = (BiayaBahanPenolong) m;
        try {
            String sql = "INSERT INTO biaya_bp(id_produk, id_bp, jumlah, total) VALUES(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, model.getIdProduk());
            ps.setInt(2, model.getIdBp());
            ps.setInt(3, model.getJumlah());
            ps.setInt(4, model.getTotal());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        BiayaBahanPenolong model = (BiayaBahanPenolong) m;
        String sql = "UPDATE alat SET id_produk=" + model.getIdProduk()
                + ", id_bp=" + model.getIdBp()
                + ", jumlah=" + model.getJumlah()
                + ", total=" + model.getTotal()
                + " WHERE id_biaya_bp=" + model.getIdBiayaBp();
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
            String sql = "DELETE from biaya_bp WHERE id_biaya_bp=" + id;
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
    protected ArrayList<BiayaBahanPenolong> getByParam(String query) {
        ArrayList<BiayaBahanPenolong> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                BiayaBahanPenolong model = new BiayaBahanPenolong();
                model.setIdBiayaBp(rs.getInt("id_biaya_bp"));
                model.setIdProduk(rs.getInt("id_produk"));
                model.setIdBp(rs.getInt("id_bp"));
                model.setJumlah(rs.getInt("jumlah"));
                model.setTotal(rs.getInt("total"));
                list.add(model);
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<BiayaBahanPenolong> getAllData() {
        String query = "SELECT * biaya_bp";
        return getByParam(query);
    }

    @Override
    public ArrayList<BiayaBahanPenolong> getById(int param) {
        String query = "SELECT * biaya_bp WHERE id_biaya_bp=" + param;
        return getByParam(query);
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected DefaultTableModel viewByParam(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel viewAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DefaultTableModel viewByParamUmum(String query) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("No");
        mdl.addColumn("Id Biaya Bp");
        mdl.addColumn("Id Produk");
        mdl.addColumn("Nama Produk");
        mdl.addColumn("Jumlah Produksi");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_biaya_bp"),
                    rs.getInt("id_produk"),
                    rs.getString("nama_produk"),
                    rs.getInt("jml_produksi")
                });
                no++;
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return mdl;
    }

    public DefaultTableModel viewAllUmum(){
        String query = "SELECT"
                        + "bb.id_biaya_bp,"
                        + "p.id_produk,"
                        + "p.nama_produk,"
                        + "p.jml_produksi"
                        + "FROM"
                        + "biaya_bp bb"
                        + "INNER JOIN produk p ON bb.id_produk = p.id_produk"
                        + "INNER JOIN bahan_penolong bp ON bb.id_bp = bp.id_bp"
                        + "GROUP BY bb.id_produk";
        return viewByParamUmum(query);
    }

    public DefaultTableModel viewByIdUmum(int id){
        String query = "SELECT"
                        + "bb.id_biaya_bp,"
                        + "p.id_produk,"
                        + "p.nama_produk,"
                        + "p.jml_produksi"
                        + "FROM"
                        + "biaya_bp bb"
                        + "INNER JOIN produk p ON bb.id_produk = p.id_produk"
                        + "INNER JOIN bahan_penolong bp ON bb.id_bp = bp.id_bp"
                        + "WHERE p.id_produk=" + id
                        + "GROUP BY bb.id_produk";
        return viewByParamUmum(query);
    }

    public DefaultTableModel viewDetailByParam(String query) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("No");
        mdl.addColumn("Id Biaya Bp");
        mdl.addColumn("Id Bahan Penolong");
        mdl.addColumn("Nama Bahan Penolong");
        mdl.addColumn("Satuan");
        mdl.addColumn("Harga Satuan");
        mdl.addColumn("Jumlah");
        mdl.addColumn("Total");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_biaya_bp"),
                    rs.getInt("id_bp"),
                    rs.getString("nama_bp"),
                    rs.getString("satuan"),
                    rs.getInt("harga_satuan"),
                    rs.getInt("jumlah"),
                    rs.getInt("total")
                });
                no++;
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return mdl;        
    }

    public DefaultTableModel viewDetailAll(int idProduk) {
        String query = "SELECT"
                        + "bb.id_biaya_bp,"
                        + "bp.id_bp,"
                        + "bp.nama_bp,"
                        + "bp.satuan,"
                        + "bp.harga_satuan,"
                        + "bb.jumlah,"
                        + "bb.total"
                        + "FROM"
                        + "biaya_bp bb"
                        + "INNER JOIN produk p ON bb.id_produk = p.id_produk"
                        + "INNER JOIN bahan_penolong bp ON bb.id_bp = bp.id_bp"
                        + "WHERE p.id_produk=" + idProduk;
        return viewDetailByParam(query);
    }

    public DefaultTableModel viewDetailById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDetailSum(int idProduk){
        int sum = 0;
        String query = "SELECT"
                        + "SUM(bb.total) as 'total'"
                        + "FROM"
                        + "biaya_bp bb"
                        + "INNER JOIN produk p ON bb.id_produk = p.id_produk"
                        + "INNER JOIN bahan_penolong bp ON bb.id_bp = bp.id_bp"
                        + "WHERE p.id_produk=" + idProduk;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                sum = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return sum;
    }
}
