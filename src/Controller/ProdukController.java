package Controller;

import DataAccessObject.ProdukDao;
import Master.Controller;
import Master.Model;
import Model.Produk;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class ProdukController extends Controller {

    private final ProdukDao dao;

    public ProdukController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new ProdukDao();
    }

    @Override
    public void create(Object... obj) {
        String namaProduk = (String) obj[0];
        int jumlahProduksi = (int) obj[1];
        int harga = (int) obj[2];
        int total = jumlahProduksi * harga;
        
        Model m = new Produk();
        Produk model = (Produk) m;
        
        model.setNamaProduk(namaProduk);
        model.setJmlProduksi(jumlahProduksi);
        model.setHarga(harga);
        model.setTotal(total);
        
        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        int idProduk = (int) obj[0];
        String namaProduk = (String) obj[1];
        int jumlahProduksi = (int) obj[2];
        int harga = (int) obj[3];
        int total = jumlahProduksi * harga;
        
        Model m = new Produk();
        Produk model = (Produk) m;
        
        model.setIdProduk(idProduk);
        model.setNamaProduk(namaProduk);
        model.setJmlProduksi(jumlahProduksi);
        model.setHarga(harga);
        model.setTotal(total);
        
        dao.update(model);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getAllData() {
        return dao.getAllData();
    }

    @Override
    public ArrayList<?> getById(int id) {
        return dao.getById(id);
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel viewAll() {
        return dao.viewAll();
    }

    public DefaultTableModel viewByNama(String nama) {
        return dao.viewByNama(nama);
    }
}
