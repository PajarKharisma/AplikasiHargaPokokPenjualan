
import DataAccessObject.ProdukDao;
import Model.Produk;
import java.sql.SQLException;
import java.util.ArrayList;


public class TestData {

    public static void main(String[] args) throws SQLException {
        ProdukDao dao = new ProdukDao();
        ArrayList<Produk> list = dao.getAllData();
        list.forEach((i) -> {
            System.out.println(i.getNamaProduk());
        });
    }
}
