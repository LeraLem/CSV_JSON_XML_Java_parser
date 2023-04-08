import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class WriteString {

    public static void writeString (String text, String filename){

        try (FileOutputStream fos = new FileOutputStream(filename)) {
            byte[] bytes = text.getBytes();
            fos.write(bytes, 0 , bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
