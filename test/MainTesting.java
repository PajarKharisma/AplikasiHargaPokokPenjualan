
import java.sql.SQLException;
import org.json.simple.JSONObject;

public class MainTesting {

    public static void main(String[] args) throws SQLException {
        JSONObject obj = new JSONObject();
        obj.put("nama", "mpkp");
        obj.put("umur", 24.5);
        obj.put("hobi", "mecahin plastik pletekan");
        
        Parse jp = new Parse();
        //jp.parse(obj);
        
        JSONObject objParent = new JSONObject();
        objParent.put("Identitas", obj);
        //System.out.println(objParent);
        jp.parse(objParent);
    }
}
