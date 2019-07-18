
import Controller.AlatController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.parser.ParseException;


public class Main {

    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ParseException {
        AlatController alatController = new AlatController();
        alatController.create("Mesin Parut Kelapa", 2, 2);
        System.out.println("SELESAI");
    }
}
