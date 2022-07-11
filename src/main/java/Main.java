import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException, JsonProcessingException {
      List<Product>pt = ReadFromFile.getInfoFromFile();
      String str = ReadUtil.getJsonFromList(pt);
        System.out.println(pt);
        System.out.println(str);




    }
}
