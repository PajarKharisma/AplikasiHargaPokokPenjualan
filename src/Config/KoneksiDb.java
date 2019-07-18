package Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.json.simple.parser.ParseException;

public class KoneksiDb {

    public Connection getConnect() throws SQLException, IOException, FileNotFoundException, ParseException {
        ReadConfig readConfig = new ReadConfig();
        Database db = readConfig.getData();
        String address = "jdbc:mysql://"+ db.getHost() +":" + db.getPort() + "/" + db.getDatabaseName();
        String username = db.getUsername();
        String password = db.getPassword();
        
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(address, username, password);
        } catch (ClassNotFoundException er) {
            System.out.println("#Error 1 : " + er.getMessage());
            System.exit(0);
        } catch (SQLException er) {
            System.out.println("#Error 2 : " + er.getMessage());
            System.exit(0);
        }
        return koneksi;
    }
}