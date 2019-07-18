package DataAccessObject;

import Master.DataAccessObject;
import Master.Model;
import Model.Produk;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class ProdukDao extends DataAccessObject {

    public ProdukDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        Produk model = (Produk) m;

        String namaProduk = model.getNamaProduk();
        int jmlProduk = model.getJmlProduksi();
        int harga = model.getHarga();
        int total = model.getTotal();

        try {
            String sql = "insert into produk(nama_produk, jml_produk, harga, total) values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, namaProduk);
            ps.setInt(2, jmlProduk);
            ps.setInt(3, harga);
            ps.setInt(4, total);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        Produk model = (Produk) m;

        int idProduk = model.getIdProduk();
        String namaProduk = model.getNamaProduk();
        int jmlProduk = model.getJmlProduksi();
        int harga = model.getHarga();
        int total = model.getTotal();
        String sql = "UPDATE produk SET nama_produk='" + namaProduk + "', jml_produksi=" + jmlProduk + ", harga=" + harga + ", total=" + total + " WHERE id_produk=" + idProduk;
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
    protected ArrayList<Produk> getByParam(String query) {
        ArrayList<Produk> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Produk model = new Produk();
                model.setIdProduk(rs.getInt("id_produk"));
                model.setNamaProduk(rs.getString("nama_produk"));
                model.setJmlProduksi(rs.getInt("jml_produksi"));
                model.setHarga(rs.getInt("harga"));
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
    public ArrayList<Produk> getAllData() {
        String query = "SELECT * FROM produk";
        return getByParam(query);
    }

    @Override
    public ArrayList<Produk> getById(int param) {
        String query = "SELECT * FROM bahan_penolong WHERE id_produk=" + param;
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
        mdl.addColumn("Id Produk");
        mdl.addColumn("Nama Produk");
        mdl.addColumn("Jumlah Produksi");
        mdl.addColumn("Harga");
        mdl.addColumn("Total");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_produk"),
                    rs.getString("nama_produk"),
                    rs.getInt("jml_produksi"),
                    rs.getInt("harga"),
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

    @Override
    public DefaultTableModel viewAll() {
        String query = "SELECT * FROM produksi";
        return viewByParam(query);
    }

    public DefaultTableModel viewByNama(String param) {
        String query = "SELECT * FROM produksi WHERE nama_produk LIKE %'" + param + "'%";
        return viewByParam(query);
    }
}
