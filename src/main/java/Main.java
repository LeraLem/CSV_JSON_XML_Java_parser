import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "C:/Valerya/CSV_JSON_parser/data.csv";
        List<Employee> list = CSVToJSONParser.parseCSV(columnMapping, fileName);
        String text = ListToJSON.listToJson(list);
        WriteString.writeString(text, "C:/Valerya/CSV_JSON_parser/data.json");
        list = ParseXML.parseXML("C:/Valerya/CSV_JSON_parser/data.xml");
        text = ListToJSON.listToJson(list);
        WriteString.writeString(text, "C:/Valerya/CSV_JSON_parser/data2.json");
        String json = ReadString.readString("C:/Valerya/CSV_JSON_parser/data.json");
        List<Employee> list2 = JsonToList.jsonToList(json);
        System.out.println(list2);
    }

}
