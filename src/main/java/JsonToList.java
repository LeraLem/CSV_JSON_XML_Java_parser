import com.google.gson.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonToList {

    public static List<Employee> jsonToList(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        List<Employee> list = new ArrayList<>();
        JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonElement str = jsonArray.get(i);
            Employee employee = gson.fromJson(str, Employee.class);
            list.add(employee);
        }
        return list;
    }
}


