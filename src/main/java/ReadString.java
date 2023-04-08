//import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadString {
    
    public static String readString(String fileName){
        JSONParser parser = new JSONParser();
        String jsonString = null;
        try {
            Object obj = parser.parse(new FileReader(fileName));
            JSONArray jsonObject = (JSONArray) obj;
            jsonString = jsonObject.toJSONString();
        } catch (IOException | ParseException | ClassCastException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
