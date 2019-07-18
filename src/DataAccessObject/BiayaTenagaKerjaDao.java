package DataAccessObject;

import Master.DataAccessObject;
import Master.Model;
import Model.BiayaTenagaKerja;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class BiayaTenagaKerjaDao extends DataAccessObject {

    public BiayaTenagaKerjaDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        BiayaTenagaKerja model = (BiayaTenagaKerja) m;
        try {
            String sql = "INSERT INTO biaya_tk(id_produk, id_jp, jml_pekerja, total) VALUES(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, model.getIdProduk());
            ps.setInt(2, model.getIdJp());
            ps.setInt(3, model.getJumlahPekerja());
            ps.setInt(4, model.getTotal());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        BiayaTenagaKerja model = (BiayaTenagaKerja) m;
        String sql = "UPDATE biaya_tk SET id_produk=" + model.getIdProduk()
                + ", id_jp=" + model.getIdJp()
                + ", jml_pekerja=" + model.getJumlahPekerja()
                + ", total=" + model.getTotal()
                + " WHERE id_btk=" + model.getIdBiayaTk();
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
            String sql = "DELETE from biaya_tk WHERE id_bp=" + id;
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
    protected ArrayList<BiayaTenagaKerja> getByParam(String query) {
        ArrayList<BiayaTenagaKerja> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                BiayaTenagaKerja model = new BiayaTenagaKerja();
                model.setIdBiayaTk(rs.getInt("id_btk"));
                model.setIdProduk(rs.getInt("id_produk"));
                model.setIdJp(rs.getInt("id_jp"));
                model.setJumlahPekerja(rs.getInt("jml_pekerja"));
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
    public ArrayList<BiayaTenagaKerja> getAllData() {
        String query = "SELECT * FROM biaya_tk";
        return getByParam(query);
    }

    @Override
    public ArrayList<BiayaTenagaKerja> getById(int id) {
        String query = "SELECT * FROM biaya_tk WHERE id_btk=" + id;
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
        mdl.addColumn("Id");
        mdl.addColumn("Id Produk");
        mdl.addColumn("Nama Produk");
        mdl.addColumn("Jumlah Produksi");
        mdl.addColumn("Total Harga");
        mdl.addColumn("Total Semua");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_btk"),
                    rs.getInt("id_produk"),
                    rs.getString("nama_produk"),
                    rs.getInt("jml_produksi"),
                    rs.getInt("total_harga"),
                    rs.getInt("total_semua")
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
                        + "bt.id_btk, p.id_produk,"
                        + "p.nama_produk, p.jml_produksi,"
                        + "SUM(bt.total) AS 'total_harga',"
                        + "(p.jml_produksi * SUM(bt.total)) AS 'total_semua'"
                        + "FROM biaya_tk bt"
                        + "INNER JOIN jenis_pekerjaan jp ON bt.id_jp = jp.id_jp"
                        + "INNER JOIN produk p ON bt.id_produk = p.id_produk"
                        + "GROUP BY bt.id_produk";
        return viewByParam(query);
    }

    public DefaultTableModel viewAllById(int id){
        String query = "SELECT"
                        + "bt.id_btk, p.id_produk,"
                        + "p.nama_produk, p.jml_produksi,"
                        + "SUM(bt.total) AS 'total_harga',"
                        + "(p.jml_produksi * SUM(bt.total)) AS 'total_semua'"
                        + "FROM biaya_tk bt"
                        + "INNER JOIN jenis_pekerjaan jp ON bt.id_jp = jp.id_jp"
                        + "INNER JOIN produk p ON bt.id_produk = p.id_produk"
                        + "WHERE p.id_produk=" + id
                        + "GROUP BY bt.id_produk";
        return viewByParam(query);
    }

    public DefaultTableModel viewAllByNamaProduk(String nama){
        String query = "SELECT"
                        + "bt.id_btk, p.id_produk,"
                        + "p.nama_produk, p.jml_produksi,"
                        + "SUM(bt.total) AS 'total_harga',"
                        + "(p.jml_produksi * SUM(bt.total)) AS 'total_semua'"
                        + "FROM biaya_tk bt"
                        + "INNER JOIN jenis_pekerjaan jp ON bt.id_jp = jp.id_jp"
                        + "INNER JOIN produk p ON bt.id_produk = p.id_produk"
                        + "WHERE p.nama_produk='" + nama + "'"
                        + "GROUP BY bt.id_produk";
        return viewByParam(query);
    }
    
    public DefaultTableModel viewDetail(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
