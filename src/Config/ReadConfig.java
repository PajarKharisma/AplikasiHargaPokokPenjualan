package Config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadConfig {
    public Database getData() throws FileNotFoundException, IOException, ParseException{
        JSONParser jsonParser = new JSONParser();
        
        FileReader reader = new FileReader("config/Config.json");
        Object obj = jsonParser.parse(reader);
        JSONObject json = (JSONObject)obj;
        JSONObject detail = (JSONObject)json.get("DatabaseConfig");
        
        String username = (String)detail.get("username");
        String password = (String)detail.get("password");
        String host = (String)detail.get("host");
        int port = (int)(long)detail.get("port");
        String databaseName = (String)detail.get("database_name");
        
        Database db = new Database(username, password, host, port, databaseName);
        return db;
    }
}
