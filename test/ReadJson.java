
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        
        FileReader reader = new FileReader("Config/Config.json");
        Object obj = jsonParser.parse(reader);
        JSONObject json = (JSONObject)obj;
        
        JSONObject detail = (JSONObject)json.get("DatabaseConfig");
        int port = (int)(long)detail.get("port");
        System.out.println(port);
//        System.out.println("Nama : " + detail.get("username"));
//        System.out.println("Password : " + detail.get("password"));
//        System.out.println("Host : " + detail.get("host"));
//        System.out.println("Port : " + detail.get("port"));
//        System.out.println("Database Name : " + detail.get("database_name"));
    }
}
