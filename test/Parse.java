
import org.json.simple.JSONObject;

public class Parse {
    public void parse(JSONObject obj){
        //String nama = (String)obj.get("nama");
        JSONObject identitas = (JSONObject)obj.get("Identitas");
        String nama = (String)identitas.get("nama");
        double umur = (double)identitas.get("umur");
        String hobi = (String)identitas.get("hobi");
        System.out.println("Nama " + nama);
        System.out.println("Umur " + umur);
        System.out.println("Hobi " + hobi);
    }
}
